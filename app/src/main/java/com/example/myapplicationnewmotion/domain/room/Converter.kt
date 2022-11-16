package com.example.myapplicationnewmotion.domain.room

import androidx.room.TypeConverter
import com.example.myapplicationnewmotion.domain.apiService.model.BalanceList
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class Converter {
    @TypeConverter
    fun stringToMeasurements(json: String?): MutableList<BalanceList?>? {
        val gson = Gson()
        val type: Type = object : TypeToken<List<BalanceList?>?>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun measurementsToString(list: List<BalanceList?>?): String? {
        val gson = Gson()
        val type: Type = object : TypeToken<List<BalanceList?>?>() {}.type
        return gson.toJson(list, type)
    }
}