package com.example.myapplicationnewmotion.service

import com.example.myapplicationnewmotion.dataModel.Data
import com.example.myapplicationnewmotion.dataModel.DataCardDetails
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface BankApi {

    @GET("card/all")
    fun getCardsVal(): Call <DataCardDetails>

    @POST
    fun addCardsVal()

    @PUT
    fun updateCardsVal()

    @DELETE
    fun removeCard()

}