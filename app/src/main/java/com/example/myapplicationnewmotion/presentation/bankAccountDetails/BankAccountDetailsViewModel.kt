package com.example.myapplicationnewmotion.presentation.bankAccountDetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplicationnewmotion.dataModel.data.Data
import com.example.myapplicationnewmotion.helper.apiService.ApiServiceImpl
import io.reactivex.rxjava3.disposables.CompositeDisposable

class BankAccountDetailsViewModel(private val mApiServiceImpl: ApiServiceImpl): ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val dataCardDetails = MutableLiveData<List<Data>>()
    val dataCardDetailsLiveData = dataCardDetails

    private val error = MutableLiveData<String>()
    val errorLiveData = error

    init {
        loadCardDetails()
    }

    // HTTP

    private fun loadCardDetails() {
        compositeDisposable.add(mApiServiceImpl.loadCardDetails().subscribe({
                dataCardDetails.value = it.data!!
        }, {
            error.value = "Ошибка на стороне сервера"
        }))
    }

}