package com.example.myapplicationnewmotion.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import com.example.myapplicationnewmotion.activities.MainActivity
import com.example.myapplicationnewmotion.databinding.FragmentPayBinding
import com.example.myapplicationnewmotion.navigator.navigator


class PayFragment : Fragment() {

    private lateinit var binding: FragmentPayBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentPayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigator().insets(binding.root)

    }

    override fun onResume() {
        super.onResume()
        navigator().hideBottomNavBar(false)
    }

    override fun onPause() {
        super.onPause()
        navigator().hideBottomNavBar(true)

    }

}