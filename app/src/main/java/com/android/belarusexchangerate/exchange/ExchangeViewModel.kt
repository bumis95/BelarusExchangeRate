package com.android.belarusexchangerate.exchange

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ExchangeViewModel : ViewModel() {

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getExchangeRate()
    }

    private fun getExchangeRate() {
        coroutineScope.launch {

        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}