package com.example.myapplicationnewmotion.di

import com.example.myapplicationnewmotion.helper.NewVmFactory
import com.example.myapplicationnewmotion.helper.VmFactory
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(): NewVmFactory
}