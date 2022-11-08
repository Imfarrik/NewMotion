package com.example.myapplicationnewmotion.di

import android.content.Context
import com.example.myapplicationnewmotion.dataModel.service.SessionManager
import com.example.myapplicationnewmotion.helper.apiService.ApiService
import com.example.myapplicationnewmotion.helper.apiService.ApiServiceImpl
import com.example.myapplicationnewmotion.presentation.auth.AuthViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun providerSessionManager(): SessionManager {
        return SessionManager(context)
    }

    @Provides
    fun providerApiServiceImpl(): ApiService {
        return ApiServiceImpl(context)
    }

    @Provides
    fun provideAuthViewModel(sessionManager: SessionManager, apiServiceImpl: ApiServiceImpl): AuthViewModel {
        return AuthViewModel(sessionManager, apiServiceImpl)
    }


}