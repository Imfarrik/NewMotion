package com.example.myapplicationnewmotion.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplicationnewmotion.databinding.FragmentLimitBinding
import com.example.myapplicationnewmotion.domain.Navigator

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

        Navigator.insets(binding.root)

        binding.let {
            it.backButton.setOnClickListener { requireActivity().onBackPressedDispatcher.onBackPressed() }
        }

    }

}