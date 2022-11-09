package com.example.myapplicationnewmotion.domain

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.navigation.NavOptions
import com.example.myapplicationnewmotion.presentation.auth.AuthActivity
import com.example.myapplicationnewmotion.presentation.containersActivity.CardInfoContainerActivity
import com.example.myapplicationnewmotion.presentation.containersActivity.CardListContainerActivity
import com.example.myapplicationnewmotion.presentation.containersActivity.MainActivity

interface Navigator {

    companion object {

        const val MY_ARG: String = "myArg"
        const val MY_ARG_POS: String = "myArgPos"
        const val CARDS_DATA: String = "cardsData"

        fun startMainActivity(activity: AuthActivity) {
            val intent = Intent(activity, MainActivity::class.java)
            activity.startActivity(intent)
            ActivityCompat.finishAffinity(activity)
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

        fun startAuthActivity(context: Context?) {
            val intent = Intent(context, AuthActivity::class.java)
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

        fun navOptions(): NavOptions {
            return NavOptions.Builder()
                .setEnterAnim(androidx.appcompat.R.anim.abc_slide_in_bottom)
                .setExitAnim(androidx.appcompat.R.anim.abc_fade_out)
                .setPopEnterAnim(androidx.appcompat.R.anim.abc_slide_in_bottom)
                .setPopExitAnim(androidx.appcompat.R.anim.abc_fade_out)
                .build()
        }

    }
}