package com.fetch.feature.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kesicollection.core.redux.creator.createStore
import com.kesicollection.core.redux.creator.reducer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

/**
 * Available action to be sent to [SearchViewModel] from [SearchScreen]
 */
sealed interface ScreenAction {
    data object Reset: ScreenAction
}

/**
 * ViewModel that manages the [SearchUiState] from the [ScreenAction] of [SearchScreen]
 */
@HiltViewModel
class SearchViewModel @Inject constructor() : ViewModel() {

    private val store = createStore(
        coroutineScope = viewModelScope,
        initialState = initialState,
        reducer = reducer<SearchUiState, ScreenAction> { state, action ->
            when (action) {
                ScreenAction.Reset -> initialState
            }
        }
    )

    val uiState = store.subscribe.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = initialState
    )

    fun dispatch(action: Any) {
        store.dispatch(action)
    }
}