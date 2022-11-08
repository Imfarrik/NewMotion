package com.example.myapplicationnewmotion.helper.apiService

import android.content.Context
import com.example.myapplicationnewmotion.dataModel.data.Data
import com.example.myapplicationnewmotion.dataModel.data.DataCardDetails
import com.example.myapplicationnewmotion.dataModel.data.GetToken
import com.example.myapplicationnewmotion.dataModel.data.SignIn
import com.example.myapplicationnewmotion.dataModel.service.RetrofitRxJavaBuilder
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class ApiServiceImpl @Inject constructor(context: Context) : ApiService {

    private val mBankApi = RetrofitRxJavaBuilder().retrofit(context)

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