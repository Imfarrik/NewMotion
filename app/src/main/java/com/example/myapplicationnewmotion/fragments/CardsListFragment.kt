package com.example.myapplicationnewmotion.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplicationnewmotion.adapter.AdapterCardInfo
import com.example.myapplicationnewmotion.dataModel.DataCardInfo
import com.example.myapplicationnewmotion.databinding.FragmentCardsBinding
import com.example.myapplicationnewmotion.navigator.Navigator
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class CardsListFragment : Fragment() {

    private lateinit var binding: FragmentCardsBinding
    private val arg by navArgs<CardsListFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCardsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Navigator.insets(binding.root)

        val cardsDataArg = getBundleArrayData(arg.cardsData)

        val myAdapter = AdapterCardInfo(cardsDataArg) { _, pos ->
            sendData(cardsDataArg, pos)
        }

        binding.let {
            it.backButtonCardsFragment.setOnClickListener { requireActivity().onBackPressed() }
            it.recycleItemCards.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            it.recycleItemCards.adapter = myAdapter
        }

    }

    private fun getBundleArrayData(arg: String): ArrayList<DataCardInfo> {
        val listType = object : TypeToken<ArrayList<DataCardInfo?>?>() {}.type
        return Gson().fromJson(arg, listType)
    }

    private fun sendData(argString: ArrayList<DataCardInfo>, argInt: Int) {
        val toJson = Gson().toJson(argString)
        Navigator.startCardInfoContainerActivity(context, toJson, argInt)
    }
}