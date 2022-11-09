package com.example.myapplicationnewmotion.presentation.cardOptionsDialog

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplicationnewmotion.domain.apiService.ApiServiceImpl
import io.reactivex.rxjava3.disposables.CompositeDisposable

class CardOptionsViewModel(private val mApiServiceImpl: ApiServiceImpl) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val text = MutableLiveData<String>()
    val textLiveData = text

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
        compositeDisposable.add(mApiServiceImpl.upDateCardVal(value).subscribe({

            text.value = "Успешно"

        }, {

            text.value = "Ошибка на стороне сервера"

        }))
    }

    private fun removeCard(id: Int) {
        compositeDisposable.add(mApiServiceImpl.removeCard(id).subscribe({

            text.value = "Карта удалена"

        }, {

            text.value = "Ошибка на стороне сервера"

        }))
    }

}