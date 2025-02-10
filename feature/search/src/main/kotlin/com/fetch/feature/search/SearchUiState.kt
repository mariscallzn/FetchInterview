package com.fetch.feature.search

import com.fetch.data.repository.SearchRepository
import com.fetch.feature.search.uimodel.UiHiringGroup

/**
 * Data class that represents the ui state for [SearchScreen]
 *
 * @property cachedItems these are cached items coming from the data source. Defaults to **empty**
 * @property isFetchingItems indicator that the data is being fetch.
 */
data class SearchUiState(
    val cachedItems: List<UiHiringGroup> = emptyList(),
    val isFetchingItems: Boolean = false,
    val error: ErrorState? = null
)

/**
 * It represent and error state
 *
 * @property type It indicate what error type has occurred
 * @property message An optional error messages for debugging
 */
data class ErrorState(
    val type: ErrorType,
    val message: String? = null
)

/**
 * Enum that all possible error that could happen in this feature
 */
enum class ErrorType {
    /**
     * Fetching data from the [SearchRepository] failed
     */
    HIRING_FETCH
}

/**
 * Initial state used by [SearchViewModel]'s state flow
 */
val initialState = SearchUiState()
