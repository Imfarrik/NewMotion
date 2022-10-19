package com.example.myapplicationnewmotion.navigator

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import com.example.myapplicationnewmotion.activities.CardInfoContainerActivity
import com.example.myapplicationnewmotion.activities.CardListContainerActivity
import com.example.myapplicationnewmotion.activities.MainActivity

interface Navigator {

    companion object {

        const val MY_ARG: String = "myArg"
        const val MY_ARG_POS: String = "myArgPos"
        const val CARDS_DATA: String = "cardsData"

        fun startMainActivity(context: Context?) {
            val intent = Intent(context, MainActivity::class.java)
            context?.startActivity(intent)
        }

        fun startCardInfoContainerActivity(context: Context?, dataString: String, dataInt: Int) {
            val intent = Intent(context, CardInfoContainerActivity::class.java)
            intent.putExtra(MY_ARG, dataString)
            intent.putExtra(MY_ARG_POS, dataInt)
            context?.startActivity(intent)
        }

        fun startCardListContainerActivity(context: Context?, dataString: String) {
            val intent = Intent(context, CardListContainerActivity::class.java)
            intent.putExtra(CARDS_DATA, dataString)
            context?.startActivity(intent)

        }

        fun insets(view: View) {
            ViewCompat.setOnApplyWindowInsetsListener(view) { _, insets ->
                val statusBarHeight = insets.getInsets(WindowInsetsCompat.Type.statusBars()).top
                val navBarHeight = insets.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom
                view.updatePadding(top = statusBarHeight, bottom = navBarHeight)
                insets
            }
        }

    }
}