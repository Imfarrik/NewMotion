package com.example.myapplicationnewmotion.di

import android.content.Context
import dagger.Module
import dagger.Provides

@Module(includes = [NetworkModule::class, DomainModule::class])
class AppModule(private val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }
}