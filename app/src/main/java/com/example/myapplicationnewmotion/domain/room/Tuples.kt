package com.example.myapplicationnewmotion.domain.room

import androidx.room.ColumnInfo

data class Remove(
    @ColumnInfo(name = "card_id")
    val cardId: Int
)