package com.example.myapplicationnewmotion.di

import android.content.Context
import com.example.myapplicationnewmotion.model.service.SharedPreferencesManager
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun providerSharedPreferencesManager(context: Context): SharedPreferencesManager {
        return SharedPreferencesManager(context)
    }

    // DataBaseManager, CacheManager, FileManager & etc.
}