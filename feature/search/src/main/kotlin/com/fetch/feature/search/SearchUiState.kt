package com.fetch.feature.search

import com.fetch.core.model.HiringItem
import com.fetch.data.repository.SearchRepository

/**
 * Data class that represents the ui state for [SearchScreen]
 *
 * @property cachedItems these are cached items coming from the data source. Defaults to **empty**
 * @property isFetchingItems indicator that the data is being fetch. Defaults to **true** because the
 * [SearchViewModel] attempt to fetch the data right away in "onStart" flow's call.
 */
data class SearchUiState(
    val cachedItems: List<HiringItem> = emptyList(),
    val isFetchingItems: Boolean = true,
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
