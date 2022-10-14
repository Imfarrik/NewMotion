package com.example.myapplicationnewmotion.fragments

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import com.example.myapplicationnewmotion.R
import com.example.myapplicationnewmotion.activities.MainActivity
import com.example.myapplicationnewmotion.databinding.FragmentCardOptionsBinding
import com.example.myapplicationnewmotion.databinding.FragmentLimitBinding
import com.example.myapplicationnewmotion.navigator.navigator

class CardOptionsFragment : Fragment() {

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

    private fun setWindowParams(){
        (activity as MainActivity).window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        (activity as MainActivity).window.setLayout(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
    }

}