package com.example.myapplicationnewmotion.di

import com.example.myapplicationnewmotion.domain.apiService.ApiService
import com.example.myapplicationnewmotion.domain.apiService.ApiServiceImpl
import com.example.myapplicationnewmotion.model.service.BankApi
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun providerApiServiceImpl(bankApi: BankApi): ApiServiceImpl {
        return ApiServiceImpl(bankApi)
    }

    @Provides
    fun providerApiService(apiServiceImpl: ApiServiceImpl): ApiService {
        return apiServiceImpl
    }
}