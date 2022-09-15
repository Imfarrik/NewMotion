package com.example.myapplicationnewmotion

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplicationnewmotion.databinding.ActivityMainBinding
import com.example.myapplicationnewmotion.fragments.BottomButtonFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val item: List<String> = (0..6).map { it.toString() }
        val myAdapter = MyAdapter(item)

        binding.itemBgRecycle.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.itemBgRecycle.adapter = myAdapter

        supportFragmentManager.beginTransaction()
            .replace(R.id.bottom_buttons, BottomButtonFragment.newInstance())
            .commit()
    }
}