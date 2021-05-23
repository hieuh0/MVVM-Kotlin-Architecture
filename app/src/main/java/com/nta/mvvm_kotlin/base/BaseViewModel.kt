package com.nta.mvvm_kotlin.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nta.mvvm_kotlin.domain.LoadingState

abstract class BaseViewModel  : ViewModel() {

   private val _loading = MutableLiveData<LoadingState>()

    val loading : LiveData<LoadingState>
    get() = _loading

    fun handlerLoading(state: LoadingState) {
        _loading.postValue(state)
    }
}