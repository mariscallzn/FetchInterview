package com.fetch.data.repository.testdouble

import com.fetch.core.model.HiringItem
import com.fetch.data.api.HiringApi

class TestHiringApi: HiringApi {

    var result: Result<List<HiringItem>> = Result.success(emptyList())

    override suspend fun fetch(): Result<List<HiringItem>> = result
}