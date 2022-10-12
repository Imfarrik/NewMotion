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
import com.example.myapplicationnewmotion.navigator.Navigator
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
            binding.navigationCardDetailsMenu.setOnApplyWindowInsetsListener {_, inset ->
                binding.navigationCardDetailsMenu.updatePadding(top = 0, bottom = 0)
                inset
            }
            insets
        }

        val itemCardInfo = binding.itemCardInfo

        itemCardInfo.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        val arg = arguments?.getString(Navigator.MY_ARG)
        val argPos = arguments?.getInt(Navigator.MY_ARG_POS)
        val listType = object : TypeToken<ArrayList<DataCardInfo?>?>() {}.type
        val convertedList: ArrayList<DataCardInfo> = Gson().fromJson(arg, listType)

        val myAdapter = AdapterCardInfo(convertedList) { _, _ -> }

        itemCardInfo.adapter = myAdapter


//        (itemCardInfo.layoutManager as LinearLayoutManager).scrollToPosition(argPos!!)
        itemCardInfo.smoothScrollToPosition(argPos!!)

        binding.backButton.setOnClickListener {
            requireActivity().onBackPressed()
        }

    }

}