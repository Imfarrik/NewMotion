package com.example.myapplicationnewmotion.activities

import android.os.Bundle
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.*
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import com.example.myapplicationnewmotion.R
import com.example.myapplicationnewmotion.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        ViewCompat.setOnApplyWindowInsetsListener(binding.bottomAppBar) { _, insets ->
            val navBarHeight = insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom
            binding.bottomNavigationView.updatePadding(bottom = navBarHeight)
            insets
        }

        val bottomNavigationView = binding.bottomNavigationView
        val navController = findNavController(R.id.fragmentContainerView)
        navController.setGraph(R.navigation.bottom_nav)

        bottomNavigationView.background = null
        bottomNavigationView.itemRippleColor = null

        val options = NavOptions.Builder()
            .setLaunchSingleTop(true)
            .setEnterAnim(androidx.appcompat.R.anim.abc_slide_in_bottom)
            .setExitAnim(androidx.appcompat.R.anim.abc_fade_out)
            .setPopEnterAnim(androidx.appcompat.R.anim.abc_slide_in_bottom)
            .setPopExitAnim(androidx.appcompat.R.anim.abc_slide_out_bottom)
            .setPopUpTo(navController.graph.startDestinationId, false)
            .build()

        bottomNavigationView.setOnItemSelectedListener { item ->
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

        bottomNavigationView.setOnItemReselectedListener {
            return@setOnItemReselectedListener
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()

        val bottomNavigationView = binding.bottomNavigationView

        if (R.id.mainFragment != bottomNavigationView.selectedItemId) {
            bottomNavigationView.selectedItemId = R.id.mainFragment
        }
    }

//    private fun completelyTransparentStatusBar() {
//        val w = window
//        w.setFlags(
//            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
//            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
//        )
}


