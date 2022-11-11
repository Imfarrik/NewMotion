package com.example.myapplicationnewmotion.domain.room.dao

import androidx.room.*
import androidx.room.Dao
import com.example.myapplicationnewmotion.domain.apiService.model.DataCardDetailsInside

@Dao
interface CardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(dataCardDetailsInside: List<DataCardDetailsInside>)

    @Query("SELECT * FROM cards")
    suspend fun getAll(): List<DataCardDetailsInside>

    @Delete
    suspend fun deleteCard(dataCardDetailsInside: DataCardDetailsInside)

    @Update
    suspend fun updateCard(dataCardDetailsInside: DataCardDetailsInside)
}