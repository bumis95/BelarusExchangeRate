package com.android.belarusexchangerate.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Bank(
    @Json(name = "street") val street: String?,
    @Json(name = "USD_in") val usd_in: Float?,
    @Json(name = "USD_out") val usd_out: Float?
)