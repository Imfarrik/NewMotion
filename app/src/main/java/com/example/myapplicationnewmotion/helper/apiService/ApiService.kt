package com.example.myapplicationnewmotion.helper.apiService

import com.example.myapplicationnewmotion.dataModel.data.Data
import com.example.myapplicationnewmotion.dataModel.data.DataCardDetails
import com.example.myapplicationnewmotion.dataModel.data.GetToken
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface ApiService {

    fun auth(password: String, login: String): Single<GetToken>

    fun loadCardDetails(): Observable<DataCardDetails>

    fun upDateCardVal(id_val: Map<String, Any>): Observable<Data>

    fun removeCard(id: Int): Single<Data>
}