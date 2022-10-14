package com.example.myapplicationnewmotion.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import com.example.myapplicationnewmotion.R
import com.example.myapplicationnewmotion.databinding.ActivityMainBinding
import com.example.myapplicationnewmotion.navigator.Navigator


class MainActivity : AppCompatActivity(), Navigator {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

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
        navController = findNavController(R.id.fragmentContainerView)
        navController.setGraph(R.navigation.main_bottom_nav_graph)

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
                    navController.navigate(R.id.mainPage, null, options)
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

    override fun hideBottomNavBar(a: Boolean) {
        if (a) {
            binding.bottomAppBar.visibility = View.GONE
            binding.floatingBottom.visibility = View.GONE
        } else {
            binding.bottomAppBar.visibility = View.VISIBLE
            binding.floatingBottom.visibility = View.VISIBLE
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

        val bottomNavigationView = binding.bottomNavigationView

        if (R.id.mainFragment != bottomNavigationView.selectedItemId) {
            bottomNavigationView.selectedItemId = R.id.mainFragment
        }
    }

    override fun insets(view: View) {
        return ViewCompat.setOnApplyWindowInsetsListener(view) { _, insets ->
            val statusBarHeight = insets.getInsets(WindowInsetsCompat.Type.statusBars()).top
            val navBarHeight = insets.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom
            view.updatePadding(top = statusBarHeight, bottom = navBarHeight)
            insets
        }
    }

    override fun onBack() {
        onBackPressed()
    }
}


