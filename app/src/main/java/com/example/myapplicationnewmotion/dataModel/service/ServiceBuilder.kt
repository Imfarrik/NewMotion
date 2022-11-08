package com.example.myapplicationnewmotion.dataModel.service

import android.content.Context
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ServiceBuilder {

    companion object {
        const val URL_ADDRESS = "http://165.22.196.62:8088/"
    }

    private fun client(context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HeaderInterceptor(context))
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(10000, TimeUnit.MILLISECONDS)
            .build()
    }

    fun retrofit(context: Context): BankApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(URL_ADDRESS)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client(context))
            .build()
        return retrofit.create(BankApi::class.java)
    }

//    fun <T> buildService(serviceType: Class<T>): T {
//        return retrofit.create(serviceType)
//    }

}