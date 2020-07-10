package com.android.belarusexchangerate.data.repository

import com.android.belarusexchangerate.data.api.ApiHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getUsers(city: String) = withContext(Dispatchers.IO) {
        apiHelper.getUsers(city)
    }
}