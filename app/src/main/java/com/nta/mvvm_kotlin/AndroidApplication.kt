package com.nta.mvvm_kotlin

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AndroidApplication : Application(){

    companion object{
       lateinit var instance : AndroidApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}