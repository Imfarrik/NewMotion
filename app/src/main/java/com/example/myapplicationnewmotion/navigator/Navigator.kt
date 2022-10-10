package com.example.myapplicationnewmotion.navigator

import android.content.Context
import android.content.Intent
import com.example.myapplicationnewmotion.activities.MainActivity

interface Navigator {

    companion object {

        fun startMainActivity(context: Context?) {
            val intent = Intent(context, MainActivity::class.java)
            context?.startActivity(intent)
        }

    }
}