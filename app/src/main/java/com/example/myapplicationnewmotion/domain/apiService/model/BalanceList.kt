package com.example.myapplicationnewmotion.domain.apiService.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "balance_list")
data class BalanceList(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    val id: Int?,

    @ColumnInfo(name = "_balance")
    val balance: Int?,

    @ColumnInfo(name = "_currency")
    val currency: String?,
)
