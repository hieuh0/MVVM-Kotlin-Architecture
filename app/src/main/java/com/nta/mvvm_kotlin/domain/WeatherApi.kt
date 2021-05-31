package com.nta.mvvm_kotlin.domain

import com.nta.mvvm_kotlin.MovieEntity
import com.nta.mvvm_kotlin.domain.entity.Weather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("/api/location/search/")
    fun getWeatherByLocation(@Query("query") keyword : String) : Call<List<Weather>>
}