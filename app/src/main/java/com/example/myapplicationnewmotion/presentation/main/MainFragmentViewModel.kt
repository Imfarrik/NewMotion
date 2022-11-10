package com.example.myapplicationnewmotion.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplicationnewmotion.di.App
import com.example.myapplicationnewmotion.domain.apiService.ApiService
import com.example.myapplicationnewmotion.model.data.DataCardDetails
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class MainFragmentViewModel : ViewModel() {

    @Inject
    lateinit var apiService: ApiService

    private val compositeDisposable = CompositeDisposable()

    private val isSuccess = MutableLiveData<Boolean>()
    val isSuccessLiveData = isSuccess

    private val dataCardDetails = MutableLiveData<DataCardDetails>()
    val dataCardDetailsLiveData = dataCardDetails

    private val error = MutableLiveData<String>()
    val errorLiveData = error

    init {
        App.getAppComponent().inject(this)
        loadCardDetails()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    // HTTP

    private fun loadCardDetails() {
        compositeDisposable.add(apiService.loadCardDetails().subscribe({
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