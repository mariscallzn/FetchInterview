package com.fetch.data.repository

import com.fetch.core.model.HiringItem
import com.fetch.data.api.HiringApi
import javax.inject.Inject
import javax.inject.Named

/**
 * This is will define how the Hiring items will be fetch by the sources
 */
interface SearchRepository {

    /**
     * Use to fetch all hiring items from disk
     *
     * @return A list of [HiringItem] wrapped on a [Result]
     */
    suspend fun fetchLocal(): Result<List<HiringItem>>

    /**
     * Use to sync with cloud and update disk
     *
     * @return A list of [HiringItem] wrapped on a [Result]
     */
    suspend fun syncItems(): Result<List<HiringItem>>
}

/**
 * This implementation orchestrate how data is returned by the consumer
 *
 * @constructor It receives only api signatures to delegate dependency resolution to a higher level
 *
 * @param networkHiringApi Expects an network implementation of [HiringApi]
 */
class SearchRepositoryImpl @Inject constructor(
    @Named("network_hiring_api") private val networkHiringApi: HiringApi,
    @Named("local_hiring_api") private val localHiringApi: HiringApi,
) : SearchRepository {
    override suspend fun fetchLocal(): Result<List<HiringItem>> =
        Result.runCatching {
            localHiringApi.fetch().getOrThrow()
        }

    /**
     * Pretty basic implementation of sync resolution
     *
     * @return list of [HiringItem] wrapped on a [Result]
     */
    override suspend fun syncItems(): Result<List<HiringItem>> = Result.runCatching {
        val results = networkHiringApi.fetch().getOrThrow()
        localHiringApi.insertAll(results).getOrThrow()
        localHiringApi.fetch().getOrThrow()
    }
}