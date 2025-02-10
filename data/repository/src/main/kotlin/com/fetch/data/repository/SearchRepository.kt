package com.fetch.data.repository

import com.fetch.core.model.HiringItem
import com.fetch.data.api.HiringApi
import javax.inject.Inject

/**
 * This is will define how the Hiring items will be fetch by the sources
 */
interface SearchRepository {

    /**
     * Use to fetch all hiring items
     *
     * @return A list of [HiringItem] wrapped on a [Result]
     */
    suspend fun fetch(): Result<List<HiringItem>>
}

/**
 * This implementation orchestrate how data is returned by the consumer
 *
 * @constructor It receives only api signatures to delegate dependency resolution to a higher level
 *
 * @param networkHiringApi Expects an network implementation of [HiringApi]
 */
class SearchRepositoryImpl @Inject constructor(
    private val networkHiringApi: HiringApi,
) : SearchRepository {
    override suspend fun fetch(): Result<List<HiringItem>> =
        Result.runCatching { networkHiringApi.fetch().getOrThrow() }
}