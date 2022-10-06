package com.example.myapplicationnewmotion.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplicationnewmotion.adapter.AdapterCardInfo
import com.example.myapplicationnewmotion.databinding.FragmentCardInfoBinding

class CardInfoFragment : Fragment() {

    private lateinit var binding: FragmentCardInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCardInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments?.getString("myArg")

        val item: List<String> = listOf("$bundle")

        val myAdapter = AdapterCardInfo(item)

        binding.itemCardInfo.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.itemCardInfo.adapter = myAdapter


    }

    companion object {
        @JvmStatic
        fun newInstance() = CardInfoFragment()

    }
}