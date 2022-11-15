package com.example.myapplicationnewmotion.domain.apiService.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "token")
data class GetTokenInside(

    @ColumnInfo(name = "access_token")
    val accessToken: String,

    @ColumnInfo(name = "refresh_token")
    val refreshToken: String
)