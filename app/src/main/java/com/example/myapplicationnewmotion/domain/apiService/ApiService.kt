package com.example.myapplicationnewmotion.domain.apiService

import com.example.myapplicationnewmotion.domain.apiService.model.Data
import com.example.myapplicationnewmotion.domain.apiService.model.DataCardDetails
import com.example.myapplicationnewmotion.domain.apiService.model.GetToken
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface ApiService {

    fun auth(password: String, login: String): Single<GetToken>

    fun loadCardDetails(): Observable<DataCardDetails>

    fun upDateCardVal(id_val: Map<String, Any>): Observable<Data>

    fun removeCard(id: Int): Single<Data>
}