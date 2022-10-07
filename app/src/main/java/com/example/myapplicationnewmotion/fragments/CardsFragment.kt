package com.example.myapplicationnewmotion.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplicationnewmotion.adapter.AdapterCardInfo
import com.example.myapplicationnewmotion.dataModel.DataCardInfo
import com.example.myapplicationnewmotion.databinding.FragmentCardsBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class CardsFragment : Fragment() {

    private lateinit var binding: FragmentCardsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCardsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recycleItemCards.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        val bundle = arguments?.getString("cardsData")

        val listType = object : TypeToken<ArrayList<DataCardInfo?>?>() {}.type
        val converter: ArrayList<DataCardInfo> = Gson().fromJson(bundle, listType)

        val myAdapter = AdapterCardInfo(converter)

        binding.recycleItemCards.adapter = myAdapter

        binding.backButtonCardsFragment.setOnClickListener {
            requireActivity().onBackPressed()
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() = CardsFragment()
    }
}