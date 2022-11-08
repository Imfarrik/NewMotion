package com.example.myapplicationnewmotion.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplicationnewmotion.dataModel.data.DataCardDetails
import com.example.myapplicationnewmotion.helper.apiService.ApiServiceImpl
import io.reactivex.rxjava3.disposables.CompositeDisposable

class MainFragmentViewModel(
    private val mApiServiceImpl: ApiServiceImpl
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val isSuccess = MutableLiveData<Boolean>()
    val isSuccessLiveData = isSuccess

    private val dataCardDetails = MutableLiveData<DataCardDetails>()
    val dataCardDetailsLiveData = dataCardDetails

    private val error = MutableLiveData<String>()
    val errorLiveData = error

    init {
        loadCardDetails()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    // HTTP

    private fun loadCardDetails() {
        compositeDisposable.add(mApiServiceImpl.loadCardDetails().subscribe({
            if (it.success) {
                isSuccess.value = true
                dataCardDetails.value = it
            } else {
                isSuccess.value = false
                error.value = "Что - то пошло не так"
            }
        }, {
            isSuccess.value = false
            error.value = "Ошибка на стороне сервера"
        }))
    }

}