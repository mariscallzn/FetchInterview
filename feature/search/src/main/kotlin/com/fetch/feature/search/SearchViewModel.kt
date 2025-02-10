package com.fetch.feature.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fetch.core.model.HiringItem
import com.fetch.data.repository.SearchRepository
import com.fetch.feature.search.domain.MapHiringItemsUseCase
import com.fetch.feature.search.uimodel.UiHiringGroup
import com.kesicollection.core.redux.creator.createAsyncThunk
import com.kesicollection.core.redux.creator.createStore
import com.kesicollection.core.redux.creator.reducer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

/**
 * Available action to be sent to [SearchViewModel] from [SearchScreen]
 */
sealed interface ScreenAction {
    data object Reset : ScreenAction
}

/**
 * ViewModel that manages the [SearchUiState] from the [ScreenAction] of [SearchScreen]
 */
@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchRepository: SearchRepository,
    private val mapHiringItemsUseCase: MapHiringItemsUseCase,
) : ViewModel() {

    private val store = createStore(
        coroutineScope = viewModelScope,
        initialState = initialState,
        reducer = reducer<SearchUiState, ScreenAction> { _, action ->
            when (action) {
                ScreenAction.Reset -> initialState
            }
        }
    )

    val uiState = store.subscribe.onStart { dispatch(fetchHiringData(Unit)) }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = initialState
    )

    fun dispatch(action: Any) {
        store.dispatch(action)
    }

    val fetchHiringData = createAsyncThunk<List<UiHiringGroup>, Unit>("fetch-hiring-data") { _, _ ->
        mapHiringItemsUseCase(searchRepository.fetch().getOrThrow())
    }.apply {
        store.builder.addCase(pending) { state, _ ->
            state.copy(
                isFetchingItems = true,
                error = null
            )
        }
        store.builder.addCase(fulfilled) { state, action ->
            action.payload.getOrNull()
                ?.let { state.copy(cachedItems = it, isFetchingItems = false) } ?: state
        }
        store.builder.addCase(rejected) { state, action ->
            state.copy(
                isFetchingItems = false,
                error = ErrorState(
                    ErrorType.HIRING_FETCH,
                    action.payload.exceptionOrNull()?.message
                )
            )
        }
    }
}