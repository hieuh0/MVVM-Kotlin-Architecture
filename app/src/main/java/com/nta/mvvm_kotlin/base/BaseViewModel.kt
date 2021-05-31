package com.nta.mvvm_kotlin.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nta.mvvm_kotlin.domain.LoadingState
import com.nta.mvvm_kotlin.utils.exception.Failure

abstract class BaseViewModel  : ViewModel() {

   private val _loading = MutableLiveData<LoadingState>()

    val loading : LiveData<LoadingState>
    get() = _loading

    private val _failure: MutableLiveData<Failure> = MutableLiveData()
    val failure: LiveData<Failure> = _failure

    protected fun handleFailure(failure: Failure) {
        _failure.value = failure
    }

    fun handlerLoading(state: LoadingState) {
        _loading.postValue(state)
    }
}