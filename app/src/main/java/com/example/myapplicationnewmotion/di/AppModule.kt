package com.example.myapplicationnewmotion.di

import android.content.Context
import com.example.myapplicationnewmotion.model.service.SessionManager
import com.example.myapplicationnewmotion.domain.apiService.ApiServiceImpl
import com.example.myapplicationnewmotion.presentation.auth.AuthViewModel
import com.example.myapplicationnewmotion.presentation.bankAccountDetails.BankAccountDetailsViewModel
import com.example.myapplicationnewmotion.presentation.cardOptionsDialog.CardOptionsViewModel
import com.example.myapplicationnewmotion.presentation.main.MainFragmentViewModel
import dagger.Module
import dagger.Provides

@Module(includes = [VmFactoryModule::class, NetworkModule::class, DomainModule::class])
class AppModule(private val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideAuthViewModel(sessionManager: SessionManager, apiServiceImpl: ApiServiceImpl): AuthViewModel {
        return AuthViewModel(sessionManager, apiServiceImpl)
    }

    @Provides
    fun provideMainViewModel(apiServiceImpl: ApiServiceImpl): MainFragmentViewModel {
        return MainFragmentViewModel(apiServiceImpl)
    }

    @Provides
    fun provideBankAccountDetailsViewModel(apiServiceImpl: ApiServiceImpl): BankAccountDetailsViewModel {
        return BankAccountDetailsViewModel(apiServiceImpl)
    }

    @Provides
    fun provideCardOptionsViewModel(apiServiceImpl: ApiServiceImpl): CardOptionsViewModel {
        return CardOptionsViewModel(apiServiceImpl)
    }


}