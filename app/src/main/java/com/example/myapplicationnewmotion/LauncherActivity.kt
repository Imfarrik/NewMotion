package com.example.myapplicationnewmotion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class LauncherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_MyApplicationNewMotion_Launcher)
        super.onCreate(savedInstanceState)

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }
}