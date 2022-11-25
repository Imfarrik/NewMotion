package com.example.myapplicationnewmotion.domain.apiService.model

import androidx.room.*
import androidx.room.ForeignKey.CASCADE

@Entity(tableName = "balance_list", foreignKeys = [ForeignKey(
    entity = DataCardDetailsInside::class,
    parentColumns = ["card_id"],
    childColumns = ["id"],
    onDelete = ForeignKey.CASCADE
)])
data class BalanceList(

    @ColumnInfo(name = "card_id")
    val card_id: Int?,

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int?,

    @ColumnInfo(name = "balance")
    val balance: Int?,

    @ColumnInfo(name = "currency")
    val currency: String?
)
