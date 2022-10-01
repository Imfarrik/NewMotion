package com.example.myapplicationnewmotion

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import com.example.myapplicationnewmotion.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        val bottomNavigationView = binding.bottomNavigationView
        val navController = findNavController(R.id.fragmentContainerView)

        bottomNavigationView.background = null

        val options = NavOptions.Builder()
            .setLaunchSingleTop(true)
            .setEnterAnim(androidx.appcompat.R.anim.abc_slide_in_bottom)
            .setExitAnim(androidx.appcompat.R.anim.abc_slide_in_bottom)
            .setPopEnterAnim(androidx.appcompat.R.anim.abc_slide_in_bottom)
            .setPopExitAnim(androidx.appcompat.R.anim.abc_slide_in_bottom)
            .setPopUpTo(navController.graph.startDestinationId, false)
            .build()

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.mainFragment -> {
                    navController.navigate(R.id.mainFragment, null, options)
                }
                R.id.transactionsFragment -> {
                    navController.navigate(R.id.transactionsFragment, null, options)
                }
                R.id.payFragment -> {
                    navController.navigate(R.id.payFragment, null, options)
                }
                R.id.settingsFragment -> {
                    navController.navigate(R.id.settingsFragment, null, options)
                }
            }
            true
        }

        bottomNavigationView.setOnNavigationItemReselectedListener {
            return@setOnNavigationItemReselectedListener
        }


    }

//    private fun completelyTransparentStatusBar() {
//        val w = window
//        w.setFlags(
//            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
//            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
//        )
//    }


}
