package com.android.belarusexchangerate.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.belarusexchangerate.data.model.Bank
import com.android.belarusexchangerate.data.repository.MainRepository
import com.android.belarusexchangerate.utils.Status
import kotlinx.coroutines.launch


class DetailViewModel(private val mainRepository: MainRepository) : ViewModel() {

    private val _banks = MutableLiveData<List<Bank>>()
    val banks: LiveData<List<Bank>>
        get() = _banks

    private val _loadingState = MutableLiveData<Status>()
    val loadingState: LiveData<Status>
        get() = _loadingState

    init {
        fetchData()
    }

    fun fetchData(city: String = "Кобрин") {
        viewModelScope.launch {
            try {
                _loadingState.value = Status.LOADING
                _banks.value = mainRepository.getUsers(city)
                _loadingState.value = Status.SUCCESS
            } catch (exception: Exception) {
                _loadingState.value = Status.ERROR
                _banks.value = listOf()
            }
        }
    }
}