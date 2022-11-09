package com.example.myapplicationnewmotion.di

import com.example.myapplicationnewmotion.model.service.RetrofitRxJavaBuilder
import com.example.myapplicationnewmotion.domain.apiService.ApiService
import com.example.myapplicationnewmotion.domain.apiService.ApiServiceImpl
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun providerApiServiceImpl(retrofitRxJavaBuilder: RetrofitRxJavaBuilder): ApiServiceImpl {
        return ApiServiceImpl(retrofitRxJavaBuilder)
    }

    @Provides
    fun providerApiService(apiServiceImpl: ApiServiceImpl): ApiService {
        return apiServiceImpl
    }
}