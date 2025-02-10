package com.fetch.interview

import com.fetch.data.api.HiringApi
import com.fetch.data.retrofit.RetrofitHiringApi
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindsHiringApi(
        api: RetrofitHiringApi
    ): HiringApi
}