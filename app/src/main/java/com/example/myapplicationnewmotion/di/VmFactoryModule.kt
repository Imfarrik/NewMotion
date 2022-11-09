package com.example.myapplicationnewmotion.di

import com.example.myapplicationnewmotion.presentation.auth.AuthViewModel
import com.example.myapplicationnewmotion.presentation.auth.AuthVmFactory
import com.example.myapplicationnewmotion.presentation.bankAccountDetails.BankAccountDetailsViewModel
import com.example.myapplicationnewmotion.presentation.bankAccountDetails.BankAccountDetailsVmFactory
import com.example.myapplicationnewmotion.presentation.cardOptionsDialog.CardOptionsViewModel
import com.example.myapplicationnewmotion.presentation.cardOptionsDialog.CardOptionsVmFactory
import com.example.myapplicationnewmotion.presentation.main.MainFragmentViewModel
import com.example.myapplicationnewmotion.presentation.main.MainFragmentVmFactory
import dagger.Module
import dagger.Provides

@Module
class VmFactoryModule {

    @Provides
    fun providerAuthViewModel(authViewModel: AuthViewModel): AuthVmFactory {
        return AuthVmFactory(authViewModel)
    }

    @Provides
    fun providerMainViewModel(mainFragmentViewModel: MainFragmentViewModel): MainFragmentVmFactory {
        return MainFragmentVmFactory(mainFragmentViewModel)
    }

    @Provides
    fun providerBankAccountDetailsViewModel(bankAccountDetailsViewModel: BankAccountDetailsViewModel): BankAccountDetailsVmFactory {
        return BankAccountDetailsVmFactory(bankAccountDetailsViewModel)
    }

    @Provides
    fun providerCardOptionsViewModel(cardOptionsViewModel: CardOptionsViewModel): CardOptionsVmFactory {
        return CardOptionsVmFactory(cardOptionsViewModel)
    }

}