package com.nta.mvvm_kotlin

import com.nta.mvvm_kotlin.domain.WeatherApi
import com.nta.mvvm_kotlin.domain.entity.Weather
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject

class WeatherService @Inject constructor(retrofit: Retrofit) : WeatherApi {

    private val moviesApi by lazy { retrofit.create(WeatherApi::class.java) }
    override fun getWeatherByLocation(keyword: String) = moviesApi.getWeatherByLocation(keyword)
}