package com.example.myapplicationnewmotion

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myapplicationnewmotion.databinding.ActivityMainBinding
import com.example.myapplicationnewmotion.fragments.BottomButtonFragment
import com.example.myapplicationnewmotion.fragments.MainFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val b = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val a = findNavController(R.id.fragmentContainerView)

        b.setupWithNavController(a)

    }
}