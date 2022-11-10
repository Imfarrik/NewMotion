package com.example.myapplicationnewmotion.di

import com.example.myapplicationnewmotion.domain.apiService.ApiService
import com.example.myapplicationnewmotion.domain.apiService.ApiServiceImpl
import com.example.myapplicationnewmotion.model.service.BankApi
import com.example.myapplicationnewmotion.model.service.HeaderInterceptor
import com.example.myapplicationnewmotion.model.service.SharedPreferencesManager
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class NetworkModule {

    @Provides
    fun providerApiService(bankApi: BankApi): ApiService {
        return ApiServiceImpl(bankApi)
    }

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
    fun provideOkHttpClient(sharedPreferencesManager: SharedPreferencesManager): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HeaderInterceptor(sharedPreferencesManager))
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(60000, TimeUnit.MILLISECONDS).build()
    }
}