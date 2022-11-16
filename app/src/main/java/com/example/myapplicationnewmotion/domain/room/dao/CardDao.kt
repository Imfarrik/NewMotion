package com.example.myapplicationnewmotion.domain.room.dao

import androidx.room.*
import androidx.room.Dao
import com.example.myapplicationnewmotion.domain.apiService.model.DataCardDetailsInside
import com.example.myapplicationnewmotion.domain.room.Remove
import kotlinx.coroutines.flow.Flow

@Dao
interface CardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(dataCardDetailsInside: List<DataCardDetailsInside>)

    @Query("SELECT * FROM cards")
    fun getAll(): Flow<List<DataCardDetailsInside>>

    @Delete(entity = DataCardDetailsInside::class)
    suspend fun removeCard(remove: Remove)

    @Update
    suspend fun updateCard(dataCardDetailsInside: DataCardDetailsInside)
}