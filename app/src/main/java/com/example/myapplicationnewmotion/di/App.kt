package com.example.myapplicationnewmotion.di

import android.app.Application

class App : Application() {

    companion object {
        private lateinit var appComponent: AppComponent
        fun getAppComponent(): AppComponent = appComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}