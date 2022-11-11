package com.example.myapplicationnewmotion.domain.apiService.model

import androidx.room.ColumnInfo
import androidx.room.Entity


@Entity(tableName = "card_detailed_info")
data class DataCardDetails(
    @ColumnInfo(name = "data")
    val data: List<DataCardDetailsInside>?,
    @ColumnInfo(name = "success")
    val success: Boolean
)