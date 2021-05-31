package com.nta.mvvm_kotlin.domain.usecase

import com.nta.mvvm_kotlin.WeatherRepositoryImp
import com.nta.mvvm_kotlin.domain.entity.Weather
import com.nta.mvvm_kotlin.utils.exception.Failure
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(private val weatherRepository: WeatherRepositoryImp) : UseCase<List<Weather>, GetWeatherUseCase.Params>(){
    override suspend fun run(params: Params): Either<Failure, List<Weather>>  = weatherRepository.getWeatherByLocation(params.keywrok)

    data class Params(val keywrok: String)
}