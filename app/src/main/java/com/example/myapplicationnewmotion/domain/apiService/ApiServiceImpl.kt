package com.example.myapplicationnewmotion.domain.apiService

import com.example.myapplicationnewmotion.model.data.Data
import com.example.myapplicationnewmotion.model.data.DataCardDetails
import com.example.myapplicationnewmotion.model.data.GetToken
import com.example.myapplicationnewmotion.model.data.SignIn
import com.example.myapplicationnewmotion.model.service.RetrofitRxJavaBuilder
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class ApiServiceImpl(retrofitRxJavaBuilder: RetrofitRxJavaBuilder) : ApiService {

    private val mBankApi = retrofitRxJavaBuilder.retrofit()

    override fun auth(password: String, login: String): Single<GetToken> {
        return mBankApi.getToken(SignIn(password, login))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun loadCardDetails(): Observable<DataCardDetails> {
        return mBankApi.getCardsVal()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun upDateCardVal(id_val: Map<String, Any>): Observable<Data> {
        return mBankApi.updateCardsVal(id_val)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun removeCard(id: Int): Single<Data> {
        return mBankApi.removeCard(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}