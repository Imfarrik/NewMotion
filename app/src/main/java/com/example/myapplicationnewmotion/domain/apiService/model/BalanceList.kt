package com.example.myapplicationnewmotion.domain.apiService.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "balance_list")
data class BalanceList(

    @PrimaryKey
    @ColumnInfo(name = "card_id")
    val id: Int?,

    @ColumnInfo(name = "balance")
    val balance: Int?,

    @ColumnInfo(name = "currency")
    val currency: String?
)
