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
            networkHiringApi = testHiringApi
        )
    }

    @Test
    fun `fetch return failure result`() = testScope.runTest {
        testHiringApi.result = Result.failure(Throwable("Error"))
        val result = repository.fetch()
        assert(result.isFailure)
    }

    @Test
    fun `fetch return success result`() = testScope.runTest {
        testHiringApi.result = Result.success(emptyList())
        val result = repository.fetch()
        assert(result.isSuccess)
    }
}