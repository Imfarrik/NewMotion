package com.example.myapplicationnewmotion.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplicationnewmotion.databinding.FragmentTransactionsBinding
import com.example.myapplicationnewmotion.domain.Navigator


class TransactionsFragment : Fragment() {

    private lateinit var binding: FragmentTransactionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTransactionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Navigator.insets(binding.root)


    }
}