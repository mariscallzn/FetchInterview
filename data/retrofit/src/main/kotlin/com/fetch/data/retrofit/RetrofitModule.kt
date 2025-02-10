package com.fetch.data.retrofit

import com.fetch.data.api.HiringApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object RetrofitModule {

    /**
     * Provides a Json setting preset
     *
     * ignoreUnknownKeys is set to true to protect front-end from crashes due to unknown keys
     */
    @Singleton
    @Provides
    fun providesJson(): Json = Json {
        ignoreUnknownKeys = true
    }

    @Singleton
    @Provides
    fun providesOkHttpCallFactory(): Call.Factory = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }).build()

    /**
     * Provides an instance of [RetrofitHiringApi]
     *
     * @return Prod network client for [RetrofitHiringApi]
     */
    @Singleton
    @Provides
    fun providesRetrofitFetchApi(json: Json, callFactory: Call.Factory): RetrofitFetchNetworkApi =
        Retrofit.Builder()
            .baseUrl("https://fetch-hiring.s3.amazonaws.com/")
            .callFactory { callFactory.newCall(it) }
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(RetrofitFetchNetworkApi::class.java)
}