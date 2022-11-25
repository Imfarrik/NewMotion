package com.example.myapplicationnewmotion.presentation.main.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplicationnewmotion.App
import com.example.myapplicationnewmotion.domain.apiService.ApiService
import com.example.myapplicationnewmotion.domain.room.AppDatabase
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
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

//    private val dataCardDetails = MutableLiveData<List<DataCardDetailsInside>>()
//    val dataCardDetailsLiveData: LiveData<List<DataCardDetailsInside>>
//        get() = dataCardDetails

    private val error = MutableLiveData<String>()
    val errorLiveData = error

    init {
        App.getAppComponent().inject(this)
        loadCardDetails()
    }

    val cardData = appDatabase.cardsDao().getAll().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

//     HTTP

    private fun loadCardDetails() {

        compositeDisposable.add(apiService.getCardList().subscribe({ it ->

            isSuccess.value = true

            viewModelScope.launch {
                appDatabase.cardsDao().insert(it.data!!)
            }

            viewModelScope.launch {
                it.data!!.forEach { cards ->
                    if (cards.isMultiCurrency!!) {
                        appDatabase.cardsDao().insertBalanceList(cards.balanceList!!)
                    }
                }
            }


        }, {
            isSuccess.value = false
            error.value = "Ошибка на стороне сервера"
        }))
    }

}