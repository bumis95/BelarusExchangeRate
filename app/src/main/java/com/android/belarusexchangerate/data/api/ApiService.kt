package com.android.belarusexchangerate.data.api

import com.android.belarusexchangerate.data.model.Bank
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api/kursExchange")
    suspend fun getExchangeRate(
        @Query("city") city: String
    ): List<Bank>
}