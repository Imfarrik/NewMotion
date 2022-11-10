package com.example.myapplicationnewmotion.di

import com.example.myapplicationnewmotion.presentation.auth.AuthViewModel
import com.example.myapplicationnewmotion.presentation.card.requisite.CardRequisiteViewModel
import com.example.myapplicationnewmotion.presentation.card.info.dialog.CardActionDialogViewModel
import com.example.myapplicationnewmotion.presentation.main.home.MainHomeViewModel
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {

    // ViewModel's

    fun inject(viewModel: AuthViewModel)
    fun inject(viewModel: MainHomeViewModel)
    fun inject(viewModel: CardRequisiteViewModel)
    fun inject(viewModel: CardActionDialogViewModel)

    // Activity's & etc
}