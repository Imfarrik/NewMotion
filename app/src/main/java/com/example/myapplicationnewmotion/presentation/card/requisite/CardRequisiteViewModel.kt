package com.example.myapplicationnewmotion.presentation.card.requisite

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplicationnewmotion.App
import com.example.myapplicationnewmotion.domain.apiService.ApiService
import com.example.myapplicationnewmotion.domain.apiService.model.Data
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class CardRequisiteViewModel : ViewModel() {

    @Inject
    lateinit var apiService: ApiService

    private val compositeDisposable = CompositeDisposable()

    private val dataCardDetails = MutableLiveData<List<Data>>()
    val dataCardDetailsLiveData = dataCardDetails

    private val error = MutableLiveData<String>()
    val errorLiveData = error

    init {
        App.getAppComponent().inject(this)
        loadCardDetails()
    }

    // HTTP

    private fun loadCardDetails() {
        compositeDisposable.add(apiService.loadCardDetails().subscribe({
            dataCardDetails.value = it.data!!
        }, {
            error.value = "Ошибка на стороне сервера"
        }))
    }

}