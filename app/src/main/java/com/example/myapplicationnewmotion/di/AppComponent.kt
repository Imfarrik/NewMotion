package com.example.myapplicationnewmotion.di

import com.example.myapplicationnewmotion.presentation.auth.AuthActivity
import com.example.myapplicationnewmotion.presentation.auth.AuthViewModel
import com.example.myapplicationnewmotion.presentation.bankAccountDetails.BankAccountDetailsFragment
import com.example.myapplicationnewmotion.presentation.bankAccountDetails.BankAccountDetailsViewModel
import com.example.myapplicationnewmotion.presentation.cardOptionsDialog.CardOptionsFragment
import com.example.myapplicationnewmotion.presentation.cardOptionsDialog.CardOptionsViewModel
import com.example.myapplicationnewmotion.presentation.main.MainFragmentViewModel
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(cardOptionsFragment: CardOptionsFragment)

    // Activity's

    fun inject(authActivity: AuthActivity)

    // ViewModel's

    fun inject(viewModel: AuthViewModel)
    fun inject(viewModel: MainFragmentViewModel)
    fun inject(viewModel: BankAccountDetailsViewModel)
    fun inject(viewModel: CardOptionsViewModel)
}