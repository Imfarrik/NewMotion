package com.example.myapplicationnewmotion.domain.room.dao

import androidx.room.*
import com.example.myapplicationnewmotion.domain.apiService.model.BalanceList
import com.example.myapplicationnewmotion.domain.apiService.model.DataCardDetailsInside
import kotlinx.coroutines.flow.Flow

@Dao
interface CardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(dataCardDetailsInside: List<DataCardDetailsInside>)

    @Query("SELECT * FROM cards")
    fun getAll(): Flow<List<DataCardDetailsInside>>

    @Query("DELETE FROM cards")
    suspend fun removeCard()

    @Update
    suspend fun updateCard(dataCardDetailsInside: DataCardDetailsInside)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBalanceList(balanceList: List<BalanceList>)
}