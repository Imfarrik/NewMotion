package com.example.myapplicationnewmotion.service

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    companion object {
        const val TOKEN =
            "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkZWZhdWx0IiwiaXNzIjoiYXNha2FiYW5rX2luZm9ybWl4IiwiZXhwIjoxNjc0OTEzNTUwfQ.jLZP-e8z6eYmL-yDLwr1MpmKOx4Pv26vSZ6goTlhEnp2Jj674lIgmgEyyyric4Ou8kEgzbyySqii_-vcyIbLHA"
    }

    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        proceed(
            request()
                .newBuilder()
                .addHeader("Authorization", TOKEN)
                .build()
        )

    }
}