package com.example.myapplicationnewmotion.di

import android.content.Context
import com.example.myapplicationnewmotion.model.service.BankApi
import com.example.myapplicationnewmotion.model.service.HeaderInterceptor
import com.example.myapplicationnewmotion.model.service.SessionManager
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class NetworkModule {

    @Provides
    fun providerBankApi(okHttpClient: OkHttpClient): BankApi {
        val retrofitRxJavaBuilder = Retrofit.Builder()
            .baseUrl("http://165.22.196.62:8088/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
        return retrofitRxJavaBuilder.create(BankApi::class.java)
    }

    @Provides
    fun provideOkHttpClient(headerInterceptor: HeaderInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(headerInterceptor)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(10000, TimeUnit.MILLISECONDS).build()
    }

    @Provides
    fun providerSessionManager(context: Context): SessionManager {
        return SessionManager(context)
    }

    @Provides
    fun providerHeaderInterceptor(context: Context): HeaderInterceptor {
        return HeaderInterceptor(context)
    }
}