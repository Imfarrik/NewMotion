package com.example.myapplicationnewmotion.fragments

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.myapplicationnewmotion.activities.CardInfoContainerActivity
import com.example.myapplicationnewmotion.activities.MainActivity
import com.example.myapplicationnewmotion.databinding.FragmentCardOptionsBinding

class CardOptionsFragment : DialogFragment() {

    private lateinit var binding: FragmentCardOptionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCardOptionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onStart() {
        super.onStart()
        setWindowParams()
    }

    private fun setWindowParams() {
        (activity as CardInfoContainerActivity).window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        (activity as CardInfoContainerActivity).window.setLayout(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
    }

}