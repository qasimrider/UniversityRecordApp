package com.learning.data.remote.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.learning.common.exception.ErrorResponse
import com.learning.common.exception.NetworkApiException
import com.learning.data.BuildConfig
import com.learning.data.remote.network.UniversityWebService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import tech.thdev.network.flowcalladapterfactory.FlowCallAdapterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitBuilder(okHttpClient: OkHttpClient, moshiBuilder: Moshi): Retrofit =
        Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addCallAdapterFactory(FlowCallAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create(moshiBuilder))
            .client(okHttpClient)
            .build()


    @Singleton
    @Provides
    fun provideOkHttp(moshi: Moshi): OkHttpClient =
        OkHttpClient.Builder()
            .readTimeout(40, TimeUnit.SECONDS)
            .writeTimeout(40, TimeUnit.SECONDS)
            .addInterceptor { chain ->
                val response = chain.proceed(chain.request())
                if (!response.isSuccessful) {
                    val errorBody = response.body?.string()
                    val adapter = moshi.adapter(ErrorResponse::class.java)
                    val error = adapter.fromJson(errorBody)
                    error?.let { throw NetworkApiException(error) }
                }
                response
            }
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    if (BuildConfig.DEBUG) setLevel(
                        HttpLoggingInterceptor.Level.BODY
                    )
                },
            ).build()

    @Singleton
    @Provides
    fun provideConverterFactory(): Moshi =
        Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()


    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): UniversityWebService {
        return retrofit.create(UniversityWebService::class.java)
    }
}