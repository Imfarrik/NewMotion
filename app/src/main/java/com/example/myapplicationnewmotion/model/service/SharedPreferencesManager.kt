package com.example.myapplicationnewmotion.model.service

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesManager(context: Context) {

    companion object {
        const val USER_TOKEN = "user_token"
        const val PREFERENCE_NAME = "share_token"
    }

    private var preferences: SharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

    fun saveAuthToken(token: String) {
        val editor = preferences.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    fun getAuthToken(): String? {
        return preferences.getString(USER_TOKEN, null)
    }
}