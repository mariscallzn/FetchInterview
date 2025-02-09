package com.fetch.feature.search

/**
 * Data class that represents the ui state for [SearchScreen]
 */
data class SearchUiState(
    val placeholder: String = "Hello, World"
)

/**
 * Initial state used by [SearchViewModel]'s state flow
 */
val initialState = SearchUiState()
