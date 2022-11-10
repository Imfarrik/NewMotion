package com.example.myapplicationnewmotion.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplicationnewmotion.databinding.ActivityLauncherBinding

class LauncherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
//        setTheme(R.style.Theme_MyApplicationNewMotion_Launcher)
        super.onCreate(savedInstanceState)
        val binding = ActivityLauncherBinding.inflate(layoutInflater)
        Log.d(TAG, "onCreate, savedState -> $savedInstanceState")
        setContentView(binding.root)
        Navigator.startAuthActivity(this)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
//        finish()
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState")
    }

    companion object {
        @JvmStatic
        val TAG = LauncherActivity::class.simpleName
    }
}