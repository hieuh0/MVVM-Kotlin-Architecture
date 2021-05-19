package com.nta.mvvm_kotlin

import com.nta.mvvm_kotlin.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel() {


    fun onLogin(){
        handlerLoading(true)

        handlerLoading(false)
    }

}