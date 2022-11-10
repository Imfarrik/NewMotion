package com.example.myapplicationnewmotion.presentation.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplicationnewmotion.di.App
import com.example.myapplicationnewmotion.domain.apiService.ApiService
import com.example.myapplicationnewmotion.model.data.GetToken
import com.example.myapplicationnewmotion.model.service.SharedPreferencesManager
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class AuthViewModel : ViewModel() {

    @Inject
    lateinit var sharedPreferencesManager: SharedPreferencesManager

    @Inject
    lateinit var apiService: ApiService

    private val compositeDisposable = CompositeDisposable()

    private val progress = MutableLiveData<Boolean>()
    val progressLiveData = progress

    private val data = MutableLiveData<GetToken>()
    val getTokenLiveData = data

    private val error = MutableLiveData<String>()
    val errorLiveData = error

    init {
        App.getAppComponent().inject(this)
    }

    fun onAutoFillClicked() {
        // do something if needed, then send request
        auth("default", "Default123\$")
    }

    fun onSignInClicked(login: String, password: String) {
        // do something if needed, then send request
        auth(login, password)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    // http

    private fun auth(login: String, password: String) {

        progress.value = true
        compositeDisposable.add(apiService.auth(password, login).subscribe({
            if (it.success) {
                data.value = it
                sharedPreferencesManager.saveAuthToken(it.data.accessToken)
            } else {
                error.value = "Неправильно указан логин или пароль"
            }
        }, {
            error.value = "Ошибка на стороне сервера"
            progress.value = false
        }))
    }
}