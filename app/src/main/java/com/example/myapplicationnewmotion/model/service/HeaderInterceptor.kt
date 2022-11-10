package com.example.myapplicationnewmotion.model.service

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor(private val sharedPreferencesManager: SharedPreferencesManager) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        sharedPreferencesManager.getAuthToken()?.let {
            requestBuilder.addHeader("Authorization", "Bearer $it")
        }
        return chain.proceed(requestBuilder.build())
    }
}