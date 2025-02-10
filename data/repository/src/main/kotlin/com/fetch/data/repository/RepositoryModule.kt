package com.fetch.data.repository

import com.fetch.data.api.HiringApi
import com.fetch.data.retrofit.RetrofitFetchNetworkApi
import com.fetch.data.retrofit.RetrofitHiringApi
import com.fetch.data.room.RoomHiringApi
import com.fetch.data.room.dao.HiringItemDao
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindsSearchRepository(
        searchRepository: SearchRepositoryImpl
    ): SearchRepository
}

@Module
@InstallIn(SingletonComponent::class)
object RepositorySourceModule {
    @Provides
    @Named("network_hiring_api")
    fun providesNetworkHiringApi(
        retrofitFetchNetworkApi: RetrofitFetchNetworkApi
    ): HiringApi = RetrofitHiringApi(retrofitFetchNetworkApi)

    @Provides
    @Named("local_hiring_api")
    fun providesLocalHiringApi(
        hiringItemDao: HiringItemDao
    ): HiringApi = RoomHiringApi(hiringItemDao)
}