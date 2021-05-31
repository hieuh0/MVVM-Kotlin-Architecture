package com.nta.mvvm_kotlin.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.nta.mvvm_kotlin.domain.LoadingState
import com.nta.mvvm_kotlin.base.BaseViewModel
import com.nta.mvvm_kotlin.domain.entity.Weather
import com.nta.mvvm_kotlin.domain.usecase.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val weatherUseCase: GetWeatherUseCase) : BaseViewModel() {

    private val _weather = MutableLiveData<List<Weather>>()

    val weather : LiveData<List<Weather>>
        get() = _weather

    fun getWeather(keywork : String){
        weatherUseCase(GetWeatherUseCase.Params(keywork),viewModelScope) {
            it.fold({ failure ->
                handleFailure(failure)
            }, { weather ->
                _weather.postValue(weather)
            })
        }
    }
}