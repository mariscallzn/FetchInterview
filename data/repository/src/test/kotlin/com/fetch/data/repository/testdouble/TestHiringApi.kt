package com.fetch.data.repository.testdouble

import com.fetch.core.model.HiringItem
import com.fetch.data.api.HiringApi

class TestHiringApi: HiringApi {

    var fetchResult: Result<List<HiringItem>> = Result.success(emptyList())
    var insertAllResult: Result<Unit> = Result.success(Unit)

    override suspend fun fetch(): Result<List<HiringItem>> = fetchResult
    override suspend fun insertAll(items: List<HiringItem>): Result<Unit> = insertAllResult
}