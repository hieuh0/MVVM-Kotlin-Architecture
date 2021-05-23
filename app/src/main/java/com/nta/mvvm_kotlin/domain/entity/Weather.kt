package com.nta.mvvm_kotlin.domain.entity

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class Weather {
    private val distance: Int? = null

    private val title: String? = null

    private val locationType: String? = null

    private val woeid: Int? = null

    private val lattLong: String? = null

}