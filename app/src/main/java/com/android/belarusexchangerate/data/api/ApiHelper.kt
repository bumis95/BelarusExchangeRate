package com.android.belarusexchangerate.data.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getBanks(city: String) = apiService.getExchangeRate(city)
}