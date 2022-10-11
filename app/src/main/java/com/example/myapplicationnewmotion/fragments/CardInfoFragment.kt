package com.example.myapplicationnewmotion.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplicationnewmotion.adapter.AdapterCardInfo
import com.example.myapplicationnewmotion.dataModel.DataCardInfo
import com.example.myapplicationnewmotion.databinding.FragmentCardInfoBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

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

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { _, insets ->
            val statusBarHeight = insets.getInsets(WindowInsetsCompat.Type.statusBars()).top
            val navBarHeight = insets.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom
            binding.root.updatePadding(top = statusBarHeight, bottom = navBarHeight)
            insets
        }

        binding.itemCardInfo.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        val bundle = arguments?.getString("myArg")
        val converter = Gson().fromJson(bundle, DataCardInfo::class.java)
        val some = arrayListOf(converter)

        val myAdapter = AdapterCardInfo(some)

        binding.itemCardInfo.adapter = myAdapter



        binding.backButton.setOnClickListener {
            requireActivity().onBackPressed()
        }

    }

}