package com.example.myapplicationnewmotion.presentation.main.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplicationnewmotion.App
import com.example.myapplicationnewmotion.domain.apiService.ApiService
import com.example.myapplicationnewmotion.domain.apiService.model.DataCardDetailsInside
import com.example.myapplicationnewmotion.domain.room.AppDatabase
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainHomeViewModel : ViewModel() {

    @Inject
    lateinit var apiService: ApiService

    @Inject
    lateinit var appDatabase: AppDatabase

    private val compositeDisposable = CompositeDisposable()

    private val isSuccess = MutableLiveData<Boolean>()
    val isSuccessLiveData = isSuccess

    private val dataCardDetails = MutableLiveData<List<DataCardDetailsInside>>()
    val dataCardDetailsLiveData: LiveData<List<DataCardDetailsInside>>
        get() = dataCardDetails

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

//     HTTP

    private fun loadCardDetails() {

        compositeDisposable.add(apiService.getCardList().subscribe({

            isSuccess.value = true

            viewModelScope.launch {
                appDatabase.cardsDao().insert(it.data!!)
                dataCardDetails.postValue(appDatabase.cardsDao().getAll())
            }

        }, {
            isSuccess.value = false
            error.value = "Ошибка на стороне сервера"
        }))
    }

}