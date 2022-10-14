package com.example.myapplicationnewmotion.navigator

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.fragment.app.Fragment
import com.example.myapplicationnewmotion.activities.CardHolderActivity
import com.example.myapplicationnewmotion.activities.ContainerActivity
import com.example.myapplicationnewmotion.activities.MainActivity

fun Fragment.navigator(): Navigator {
    return requireActivity() as Navigator
}

interface Navigator {

    companion object {

        const val MY_ARG: String = "myArg"
        const val MY_ARG_POS: String = "myArgPos"
        const val CARDS_DATA: String = "cardsData"

        fun startMainActivity(context: Context?) {
            val intent = Intent(context, MainActivity::class.java)
            context?.startActivity(intent)
        }

        fun startCardHolderActivity(context: Context?, dataString: String, dataInt: Int) {
            val intent = Intent(context, CardHolderActivity::class.java)
            intent.putExtra(MY_ARG, dataString)
            intent.putExtra(MY_ARG_POS, dataInt)
            context?.startActivity(intent)
        }

        fun startContainerActivity(context: Context?, dataString: String) {
            val intent = Intent(context, ContainerActivity::class.java)
            intent.putExtra(CARDS_DATA, dataString)
            context?.startActivity(intent)

        }

    }

    fun insets(view: View)

    fun onBack()

    fun hideBottomNavBar(a: Boolean)
}