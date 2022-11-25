package com.example.myapplicationnewmotion.di

import android.content.Context
import androidx.room.Room
import com.example.myapplicationnewmotion.domain.apiService.ApiService
import com.example.myapplicationnewmotion.domain.apiService.ApiServiceImpl
import com.example.myapplicationnewmotion.domain.apiService.BankApi
import com.example.myapplicationnewmotion.domain.apiService.HeaderInterceptor
import com.example.myapplicationnewmotion.domain.room.*
import com.example.myapplicationnewmotion.domain.shared_pref.SharedPreferencesManager
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module(includes = [NetworkModule::class, DomainModule::class])
class AppModule(private val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }
}

@Module
class DomainModule {

    @Provides
    fun providerSharedPreferencesManager(context: Context): SharedPreferencesManager {
        return SharedPreferencesManager(context)
    }

    @Provides
    fun providerDataCardDetailedInfoBD(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "new_motion_database")
            .addMigrations(MIGRATION_1_2)
            .addMigrations(MIGRATION_2_3)
            .addMigrations(MIGRATION_3_4)
            .addMigrations(MIGRATION_4_5)
            .build()
    }

    // DataBaseManager, CacheManager, FileManager & etc.
}

@Module
class NetworkModule {

    @Provides
    fun providerApiService(bankApi: BankApi): ApiService {
        return ApiServiceImpl(bankApi)
    }

    @Provides
    fun providerBankApi(okHttpClient: OkHttpClient): BankApi {
        val retrofitRxJavaBuilder = Retrofit.Builder()
            .baseUrl("http://165.22.196.62:8088/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
        return retrofitRxJavaBuilder.create(BankApi::class.java)
    }

    @Provides
    fun provideOkHttpClient(sharedPreferencesManager: SharedPreferencesManager): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HeaderInterceptor(sharedPreferencesManager))
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(60000, TimeUnit.MILLISECONDS).build()
    }
}