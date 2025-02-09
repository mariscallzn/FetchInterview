package com.fetch.feature.me

/**
 * Data class that represent the ui state
 */
data class MeUiState(
    val placeholder: String = "Hello, World"
)

/**
 * Initial state used by [MeViewModel] state flow
 */
val initialState = MeUiState()