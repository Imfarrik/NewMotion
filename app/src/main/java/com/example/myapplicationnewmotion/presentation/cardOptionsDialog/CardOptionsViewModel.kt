package com.example.myapplicationnewmotion.presentation.cardOptionsDialog

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplicationnewmotion.di.App
import com.example.myapplicationnewmotion.domain.apiService.ApiService
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class CardOptionsViewModel : ViewModel() {

    @Inject
    lateinit var apiService: ApiService

    private val compositeDisposable = CompositeDisposable()

    private val text = MutableLiveData<String>()
    val textLiveData = text

    init {
        App.getAppComponent().inject(this)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun updatePhoneNumber(value: Map<String, Any>) {
        updateCardVal(value)
    }

    fun updateCardStatus(value: Map<String, Any>) {
        updateCardVal(value)
    }

    fun removeCardById(id: Int) {
        removeCard(id)
    }

    // HTTP

    private fun updateCardVal(value: Map<String, Any>) {
        compositeDisposable.add(apiService.upDateCardVal(value).subscribe({

            text.value = "Успешно"

        }, {

            text.value = "Ошибка на стороне сервера"

        }))
    }

    private fun removeCard(id: Int) {
        compositeDisposable.add(apiService.removeCard(id).subscribe({

            text.value = "Карта удалена"

        }, {

            text.value = "Ошибка на стороне сервера"

        }))
    }

}