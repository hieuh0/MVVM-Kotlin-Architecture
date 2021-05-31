package com.nta.mvvm_kotlin

import com.nta.mvvm_kotlin.domain.WeatherApi
import com.nta.mvvm_kotlin.domain.entity.Weather
import com.nta.mvvm_kotlin.domain.usecase.Either
import com.nta.mvvm_kotlin.domain.usecase.Either.Left
import com.nta.mvvm_kotlin.domain.usecase.Either.Right
import com.nta.mvvm_kotlin.utils.NetworkHandler
import com.nta.mvvm_kotlin.utils.exception.Failure
import retrofit2.Call
import javax.inject.Inject

interface WeatherRepositoryImp {
    fun getWeatherByLocation(keywork : String): Either<Failure, List<Weather>>

    class WeatherRepository @Inject constructor(
        private val networkHandler: NetworkHandler,
        private val apiService: WeatherApi
    ) : WeatherRepositoryImp {
        override fun getWeatherByLocation(keywork : String): Either<Failure, List<Weather>> {
            return when (networkHandler.isNetworkAvailable()) {
                true -> request(apiService.getWeatherByLocation(keywork), {
                    it.map { weather ->
                        weather
                    }
                }, emptyList())
                false -> Left(Failure.NetworkConnection)
            }
        }

        private fun <T, R> request(
            call: Call<T>,
            transform: (T) -> R,
            default: T
        ): Either<Failure, R> {
            return try {
                val response = call.execute()
                when (response.isSuccessful) {
                    true -> Right(transform((response.body() ?: default)))
                    false -> Left(Failure.ServerError)
                }
            } catch (exception: Throwable) {
                Left(Failure.ServerError)
            }
        }
    }
}

data class MovieEntity(private val id: Int, private val poster: String) {
    fun toMovie() = Weather(id, poster)
}