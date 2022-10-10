package com.example.myapplicationnewmotion.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationnewmotion.adapter.AdapterCardInfo
import com.example.myapplicationnewmotion.dataModel.DataCardInfo
import com.example.myapplicationnewmotion.databinding.FragmentCardsBinding
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

        val myAdapter: AdapterCardInfo
        val convertedList: ArrayList<DataCardInfo>
        val recyclerView: RecyclerView = binding.recycleItemCards

        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        val bundle = arguments?.getString("cardsData")
        val listType = object : TypeToken<ArrayList<DataCardInfo?>?>() {}.type
        convertedList = Gson().fromJson(bundle, listType)

        myAdapter = AdapterCardInfo(convertedList)

        recyclerView.adapter = myAdapter

        myAdapter.onItemClick = {
            val a = Gson().toJson(it)
            val b = bundleOf("myArg" to a)
            CardsFragmentDirections.cardsFragmentToCardInfoFragment2().let { that ->
                findNavController().navigate(
                    that.actionId,
                    b
                )
            }
        }

        binding.backButtonCardsFragment.setOnClickListener {
            requireActivity().onBackPressed()
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() = CardsFragment()
    }
}