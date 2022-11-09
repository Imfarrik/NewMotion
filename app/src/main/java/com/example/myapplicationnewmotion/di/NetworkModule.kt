package com.example.myapplicationnewmotion.di

import android.content.Context
import com.example.myapplicationnewmotion.model.service.HeaderInterceptor
import com.example.myapplicationnewmotion.model.service.RetrofitRxJavaBuilder
import com.example.myapplicationnewmotion.model.service.SessionManager
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    fun providerRetrofitRxJavaBuilder(headerInterceptor: HeaderInterceptor): RetrofitRxJavaBuilder {
        return RetrofitRxJavaBuilder(headerInterceptor)
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