package com.example.myapplicationnewmotion.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationnewmotion.activities.MainActivity
import com.example.myapplicationnewmotion.adapter.AdapterCardInfo
import com.example.myapplicationnewmotion.dataModel.DataCardInfo
import com.example.myapplicationnewmotion.databinding.FragmentCardsBinding
import com.example.myapplicationnewmotion.navigator.Navigator
import com.example.myapplicationnewmotion.navigator.navigator
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class CardsFragment : Fragment() {

    private lateinit var binding: FragmentCardsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCardsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigator().insets(binding.root)

        val myAdapter: AdapterCardInfo
        val convertedList: ArrayList<DataCardInfo>
        val recyclerView: RecyclerView = binding.recycleItemCards

        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        val bundle = arguments?.getString(Navigator.CARDS_DATA)
        val listType = object : TypeToken<ArrayList<DataCardInfo?>?>() {}.type
        convertedList = Gson().fromJson(bundle, listType)

        myAdapter = AdapterCardInfo(convertedList) { _, pos ->
            val toJson = Gson().toJson(convertedList)
            val bundlePost = bundleOf(Navigator.MY_ARG to toJson, Navigator.MY_ARG_POS to pos)
            CardsFragmentDirections.cardsFragmentToCardInfoFragment().let { that ->
                findNavController().navigate(
                    that.actionId,
                    bundlePost
                )
            }
        }

        recyclerView.adapter = myAdapter

        binding.backButtonCardsFragment.setOnClickListener {
            navigator().onBack()
        }

    }
}