package com.example.myapplicationnewmotion

import android.app.Application
import com.example.myapplicationnewmotion.di.AppComponent
import com.example.myapplicationnewmotion.di.AppModule
import com.example.myapplicationnewmotion.di.DaggerAppComponent

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