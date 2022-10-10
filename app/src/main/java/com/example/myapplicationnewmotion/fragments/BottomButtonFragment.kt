package com.example.myapplicationnewmotion.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplicationnewmotion.R
import com.example.myapplicationnewmotion.databinding.FragmentBottomButtonBinding


class BottomButtonFragment : Fragment() {

    private lateinit var binding: FragmentBottomButtonBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBottomButtonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



//        binding.transactionBtnBg.setOnClickListener {
//            requireActivity().supportFragmentManager.beginTransaction()
//                .add(R.id.mainActivity, TransactionsFragment.newInstance())
//                .commitNow()
//        }
//
//        binding.homeBtnBg.setOnClickListener {
//            requireActivity().supportFragmentManager.beginTransaction()
//                .replace(R.id.mainActivity, MainFragment.newInstance())
//                .commitNow()
//        }
//
//        binding.payBtnBg.setOnClickListener {
//            requireActivity().supportFragmentManager.beginTransaction()
//                .add(R.id.mainActivity, PayFragment.newInstance())
//                .commitNow()
//        }
//
//        binding.settingsBtnBg.setOnClickListener {
//            requireActivity().supportFragmentManager.beginTransaction()
//                .add(R.id.mainActivity, SettingsFragment.newInstance())
//                .commitNow()
//        }

    }

}