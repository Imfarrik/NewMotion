package com.example.myapplicationnewmotion.presentation.card.info.dialog

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplicationnewmotion.App
import com.example.myapplicationnewmotion.domain.apiService.ApiService
import com.example.myapplicationnewmotion.domain.room.AppDatabase
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.coroutines.launch
import javax.inject.Inject

class CardActionDialogViewModel : ViewModel() {

    @Inject
    lateinit var apiService: ApiService

    @Inject
    lateinit var appDatabase: AppDatabase

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

            viewModelScope.launch {
                appDatabase.cardsDao().removeCard()
            }

        }, {

            text.value = "Ошибка на стороне сервера"

        }))
    }

}