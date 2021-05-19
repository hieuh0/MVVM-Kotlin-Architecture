package com.nta.mvvm_kotlin.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
   private val _loading = MutableLiveData<Boolean>()

    val loading
    get() = _loading

    fun handlerLoading(isLoading: Boolean) {
        _loading.postValue(isLoading)
    }
}