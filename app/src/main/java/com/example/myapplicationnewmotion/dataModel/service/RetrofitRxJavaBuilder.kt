package com.example.myapplicationnewmotion.dataModel.service

import android.content.Context
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitRxJavaBuilder {

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
        val retrofitRxJavaBuilder = Retrofit.Builder()
            .baseUrl(URL_ADDRESS)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(client(context))
            .build()
        return retrofitRxJavaBuilder.create(BankApi::class.java)
    }
}
