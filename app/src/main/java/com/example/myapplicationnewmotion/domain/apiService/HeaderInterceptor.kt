package com.example.myapplicationnewmotion.domain.apiService

import com.example.myapplicationnewmotion.domain.shared_pref.SharedPreferencesManager
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