package com.fetch.data.repository

import com.fetch.data.repository.testdouble.TestHiringApi
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import kotlin.test.Test

class SearchRepositoryTest {

    private val testScope = TestScope(UnconfinedTestDispatcher())

    private lateinit var repository: SearchRepository
    private lateinit var testHiringApi: TestHiringApi

    @Before
    fun setup() {
        testHiringApi = TestHiringApi()
        repository = SearchRepositoryImpl(
            networkHiringApi = testHiringApi,
            localHiringApi = testHiringApi,
        )
    }

    @Test
    fun fetch_fails() = testScope.runTest {
        testHiringApi.fetchResult = Result.failure(Throwable("Error"))
        val result = repository.fetchLocal()
        assert(result.isFailure)
    }

    @Test
    fun fetch_succeed() = testScope.runTest {
        testHiringApi.fetchResult = Result.success(emptyList())
        val result = repository.fetchLocal()
        assert(result.isSuccess)
    }
}