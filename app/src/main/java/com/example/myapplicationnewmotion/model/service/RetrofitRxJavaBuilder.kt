package com.example.myapplicationnewmotion.model.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitRxJavaBuilder(private val headerInterceptor: HeaderInterceptor) {

    companion object {
        const val URL_ADDRESS = "http://165.22.196.62:8088/"
    }

    private fun client(): OkHttpClient {
        return OkHttpClient.Builder()
//            .addInterceptor(HeaderInterceptor(context))
            .addInterceptor(headerInterceptor).addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(10000, TimeUnit.MILLISECONDS).build()
    }

    fun retrofit(): BankApi {
        val retrofitRxJavaBuilder = Retrofit.Builder().baseUrl(URL_ADDRESS).addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create()).client(client()).build()
        return retrofitRxJavaBuilder.create(BankApi::class.java)
    }
}
