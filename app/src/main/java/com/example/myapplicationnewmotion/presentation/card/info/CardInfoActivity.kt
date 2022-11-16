package com.example.myapplicationnewmotion.presentation.card.info

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.*
import androidx.navigation.fragment.NavHostFragment
import com.example.myapplicationnewmotion.R
import com.example.myapplicationnewmotion.databinding.ActivityCardHolderBinding


class CardInfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCardHolderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCardHolderBinding.inflate(layoutInflater)

        setContentView(binding.root)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
        val navController = navHostFragment.navController
        navController
            .setGraph(R.navigation.card_details_graph, intent.extras)

    }
}