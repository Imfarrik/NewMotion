package com.example.myapplicationnewmotion.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplicationnewmotion.activities.MainActivity
import com.example.myapplicationnewmotion.databinding.FragmentTransactionsBinding


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



    }
    override fun onResume() {
        super.onResume()
        (activity as MainActivity).hideBottomNavBar(false)
    }

    override fun onPause() {
        super.onPause()
        (activity as MainActivity).hideBottomNavBar(true)

    }
}