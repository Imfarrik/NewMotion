package com.example.myapplicationnewmotion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager

class LaunchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        val thread = Thread(Runnable {
            Thread.sleep(2000)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
        thread.start()

        completelyTransparentStatusBar()
    }

    protected override fun onPause() {
        super.onPause()
        finish()
    }

    private fun completelyTransparentStatusBar() {
        val w = window
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }
}