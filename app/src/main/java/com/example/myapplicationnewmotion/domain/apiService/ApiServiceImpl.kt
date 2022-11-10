package com.example.myapplicationnewmotion.domain.apiService

import com.example.myapplicationnewmotion.domain.apiService.model.Data
import com.example.myapplicationnewmotion.domain.apiService.model.DataCardDetails
import com.example.myapplicationnewmotion.domain.apiService.model.GetToken
import com.example.myapplicationnewmotion.domain.apiService.model.SignIn
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class ApiServiceImpl(private val bankApi: BankApi) : ApiService {

    override fun auth(password: String, login: String): Single<GetToken> {
        return bankApi.getToken(SignIn(password, login))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun loadCardDetails(): Observable<DataCardDetails> {
        return bankApi.getCardsVal()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun upDateCardVal(id_val: Map<String, Any>): Observable<Data> {
        return bankApi.updateCardsVal(id_val)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun removeCard(id: Int): Single<Data> {
        return bankApi.removeCard(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}