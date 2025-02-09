package com.fetch.feature.me

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

/**
 * ViewModel that manages UIState and User interactions for [MeScreen]
 */
@HiltViewModel
class MeViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(initialState)
    val uiState: StateFlow<MeUiState>
        get() = _uiState.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = initialState
        )

}