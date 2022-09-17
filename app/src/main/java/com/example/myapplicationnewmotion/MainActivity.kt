package com.example.myapplicationnewmotion

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplicationnewmotion.databinding.ActivityMainBinding
import com.example.myapplicationnewmotion.fragments.BottomButtonFragment
import com.example.myapplicationnewmotion.fragments.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.mainActivity, MainFragment.newInstance())
            .commit()

        supportFragmentManager.beginTransaction()
            .replace(R.id.bottom_buttons, BottomButtonFragment.newInstance())
            .commitNow()
    }
}