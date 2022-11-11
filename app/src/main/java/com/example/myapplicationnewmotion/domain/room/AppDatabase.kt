package com.example.myapplicationnewmotion.domain.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplicationnewmotion.domain.apiService.model.DataCardDetailsInside
import com.example.myapplicationnewmotion.domain.room.dao.CardDao


@Database(
    entities = [DataCardDetailsInside::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun cardsDao(): CardDao

}