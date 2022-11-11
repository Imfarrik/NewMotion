package com.example.myapplicationnewmotion.domain.apiService.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class LocalDB {
    val dataCardDetails = MutableLiveData<List<DataCardDetailsInside>>()
    val dataCardDetailsLiveData: LiveData<List<DataCardDetailsInside>>
        get() = dataCardDetails
}