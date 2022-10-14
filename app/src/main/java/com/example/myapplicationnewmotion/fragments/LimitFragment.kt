package com.example.myapplicationnewmotion.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import com.example.myapplicationnewmotion.R
import com.example.myapplicationnewmotion.databinding.FragmentLimitBinding
import com.example.myapplicationnewmotion.navigator.navigator

class LimitFragment : Fragment() {

    private lateinit var binding: FragmentLimitBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLimitBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigator().insets(binding.root)

        binding.backButton.setOnClickListener {
            navigator().onBack()
        }


    }

}