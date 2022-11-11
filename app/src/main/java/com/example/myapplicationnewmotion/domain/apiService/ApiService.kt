package com.example.myapplicationnewmotion.domain.apiService

import com.example.myapplicationnewmotion.domain.apiService.model.DataCardDetailsInside
import com.example.myapplicationnewmotion.domain.apiService.model.DataCardDetails
import com.example.myapplicationnewmotion.domain.apiService.model.GetToken
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface ApiService {

    fun auth(password: String, login: String): Single<GetToken>

    fun getCardList(): Observable<DataCardDetails>

    fun upDateCardVal(id_val: Map<String, Any>): Observable<DataCardDetailsInside>

    fun removeCard(id: Int): Single<DataCardDetailsInside>
}