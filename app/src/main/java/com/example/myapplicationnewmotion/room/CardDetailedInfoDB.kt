package com.example.myapplicationnewmotion.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplicationnewmotion.domain.apiService.model.DataCardDetailsInside


@Database(
    entities = [DataCardDetailsInside::class],
    version = 1
)
abstract class CardDetailedInfoDB : RoomDatabase() {

    abstract fun getCardDetailedInfoDao(): Dao

}