package com.example.myapplicationnewmotion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplicationnewmotion.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val item: List<String> = (0..6).map { it.toString() }
        val myAdapter = MyAdapter(item)

        binding.itemBgRecycle.adapter = myAdapter
    }
}