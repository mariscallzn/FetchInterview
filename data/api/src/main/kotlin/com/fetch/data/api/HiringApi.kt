package com.fetch.data.api

import com.fetch.core.model.HiringItem

/**
 * Data source definition
 */
interface HiringApi {
    /**
     * It will retrieve all Hiring items
     *
     * @return The list of Hiring items wrapped on a [Result]
     */
    suspend fun fetch(): Result<List<HiringItem>>

    /**
     * It will insert all items
     * @return a wrapper [Result] of type unit
     */
    suspend fun insertAll(items: List<HiringItem>): Result<Unit>
}