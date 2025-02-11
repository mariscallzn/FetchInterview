package com.fetch.data.retrofit

import com.fetch.core.model.HiringItem
import com.fetch.data.api.HiringApi
import javax.inject.Inject

class RetrofitHiringApi @Inject constructor(
    private val retrofitFetchNetworkApi: RetrofitFetchNetworkApi,
) : HiringApi {
    override suspend fun fetch(): Result<List<HiringItem>> = Result.runCatching {
        retrofitFetchNetworkApi.fetchHiringItems()
    }

    override suspend fun insertAll(items: List<HiringItem>): Result<Unit> =
        Result.failure(Throwable("No end point available"))
}