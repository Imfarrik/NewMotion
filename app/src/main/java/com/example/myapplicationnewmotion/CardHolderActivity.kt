package com.example.myapplicationnewmotion

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.fragment.NavHostFragment
import com.example.myapplicationnewmotion.databinding.ActivityCardHolderBinding


class CardHolderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCardHolderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardHolderBinding.inflate(layoutInflater)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(binding.root)

//        ViewCompat.setOnApplyWindowInsetsListener(binding.containerCardInfo) { v: View, insets: WindowInsetsCompat ->
//            (v.layoutParams as MarginLayoutParams).topMargin = insets.systemWindowInsetTop
//            insets.consumeSystemWindowInsets()
//        }


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
        val navController = navHostFragment.navController
        navController
            .setGraph(R.navigation.trans_graph, intent.extras)


    }
}