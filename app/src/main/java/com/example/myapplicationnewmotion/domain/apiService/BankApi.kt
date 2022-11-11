package com.example.myapplicationnewmotion.domain.apiService

import com.example.myapplicationnewmotion.domain.apiService.model.DataCardDetails
import com.example.myapplicationnewmotion.domain.apiService.model.DataCardDetailsInside
import com.example.myapplicationnewmotion.domain.apiService.model.GetToken
import com.example.myapplicationnewmotion.domain.apiService.model.SignIn
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.http.*

interface BankApi {

    @GET("card/all")
    fun getCardsVal(): Observable<DataCardDetails>

    @PUT("card/update")
    @JvmSuppressWildcards
    fun updateCardsVal(@Body id_val: Map<String, Any>): Observable<DataCardDetailsInside>

    @DELETE("card/{id}")
    fun removeCard(@Path("id") id: Int): Single<DataCardDetailsInside>

    @POST("card/new")
    fun addCardNewCard(@Body data: DataCardDetailsInside): Call<DataCardDetailsInside>

    @POST("auth/login")
    fun getToken(@Body signIn: SignIn): Single<GetToken>


//    @FormUrlEncoded
//    @PUT("card/update")
//    fun updateCardsVal(
//        @Field("cardId")cardId: Int,
//        @Field("smsServiceState")smsServiceState: Int,
//        @Field("smsServiceStateName")smsServiceStateName: String
//    ): Call<Data>

//    @FormUrlEncoded
//    @PUT("card/update")
//    fun updateCardsValStatus(
//        @Field("cardId")cardId: Int,
//        @Field("smsServiceState")smsServiceState: Int,
//    ): Call<Data>


}