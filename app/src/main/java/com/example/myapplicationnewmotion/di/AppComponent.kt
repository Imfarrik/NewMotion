package com.example.myapplicationnewmotion.di

import com.example.myapplicationnewmotion.presentation.auth.AuthActivity
import com.example.myapplicationnewmotion.presentation.bankAccountDetails.BankAccountDetailsFragment
import com.example.myapplicationnewmotion.presentation.cardOptionsDialog.CardOptionsFragment
import com.example.myapplicationnewmotion.presentation.main.MainFragment
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(authActivity: AuthActivity)

    fun inject(mainFragment: MainFragment)

    fun inject(bankAccountDetailsFragment: BankAccountDetailsFragment)

    fun inject(cardOptionsFragment: CardOptionsFragment)
}