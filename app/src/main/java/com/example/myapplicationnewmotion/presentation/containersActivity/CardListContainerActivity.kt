package com.example.myapplicationnewmotion.presentation.containersActivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.*
import androidx.navigation.fragment.NavHostFragment
import com.example.myapplicationnewmotion.R
import com.example.myapplicationnewmotion.databinding.ActivityContainerBinding

class CardListContainerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContainerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContainerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView3) as NavHostFragment
        val navController = navHostFragment.navController
        navController
            .setGraph(R.navigation.cards_list_graph, intent.extras)

    }
}