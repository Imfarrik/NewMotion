package com.example.myapplicationnewmotion.room

import androidx.room.*
import androidx.room.Dao
import com.example.myapplicationnewmotion.domain.apiService.model.DataCardDetailsInside

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(dataCardDetailsInside: List<DataCardDetailsInside>)

    @Query("SELECT * FROM card_detailed_info_inside")
    suspend fun getAll(): List<DataCardDetailsInside>

    @Delete
    suspend fun deleteCard(dataCardDetailsInside: DataCardDetailsInside)

    @Update
    suspend fun updateCard(dataCardDetailsInside: DataCardDetailsInside)
}