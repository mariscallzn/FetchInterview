package com.fetch.data.retrofit

import com.fetch.core.model.HiringItem
import retrofit2.http.GET

interface RetrofitFetchNetworkApi {
    @GET(value = "hiring.json")
    suspend fun fetchHiringItems(): List<HiringItem>
}