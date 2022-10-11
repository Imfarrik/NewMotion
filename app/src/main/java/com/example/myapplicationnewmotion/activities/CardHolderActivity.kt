package com.example.myapplicationnewmotion.activities

import android.os.Bundle
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.*
import androidx.navigation.fragment.NavHostFragment
import com.example.myapplicationnewmotion.R
import com.example.myapplicationnewmotion.databinding.ActivityCardHolderBinding


class CardHolderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCardHolderBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCardHolderBinding.inflate(layoutInflater)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        setContentView(binding.root)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
        val navController = navHostFragment.navController
        navController
            .setGraph(R.navigation.trans_graph, intent.extras)


    }
}