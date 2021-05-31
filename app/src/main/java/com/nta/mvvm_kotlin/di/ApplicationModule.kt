package com.nta.mvvm_kotlin.di

import com.nta.mvvm_kotlin.BuildConfig
import com.nta.mvvm_kotlin.WeatherRepositoryImp
import com.nta.mvvm_kotlin.domain.WeatherApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun provideRetrofit(): WeatherApi {
        return Retrofit.Builder()
            .baseUrl("https://www.metaweather.com")
            .client(createClient())
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }

    private fun createClient(): OkHttpClient {
        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val loggingInterceptor =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
            okHttpClientBuilder.addInterceptor(loggingInterceptor)
        }
        return okHttpClientBuilder.build()
    }


    @Provides
    @Singleton
    fun provideWeatherRepository(dataSource: WeatherRepositoryImp.WeatherRepository): WeatherRepositoryImp = dataSource
}