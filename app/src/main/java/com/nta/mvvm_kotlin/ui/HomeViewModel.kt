package com.nta.mvvm_kotlin.ui

import com.nta.mvvm_kotlin.domain.LoadingState
import com.nta.mvvm_kotlin.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel() {

    fun loading(){
        handlerLoading(LoadingState.RUNNING)
    }
}