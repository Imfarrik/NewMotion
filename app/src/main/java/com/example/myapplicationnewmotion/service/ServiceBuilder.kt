package com.example.myapplicationnewmotion.service

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ServiceBuilder {

    companion object{
        const val URL_ADDRESS = "http://165.22.196.62:8088/"
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(HeaderInterceptor())
        .connectTimeout(10000, TimeUnit.MILLISECONDS)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(URL_ADDRESS)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

//    val api = retrofit.create(BankApi::class.java)
//    val request = api.getCardsVal()

    fun <T> buildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }

}