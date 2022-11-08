package com.example.myapplicationnewmotion.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplicationnewmotion.helper.VmFactory
import com.example.myapplicationnewmotion.databinding.FragmentMainBinding
import com.example.myapplicationnewmotion.helper.adapter.MyAdapter
import com.example.myapplicationnewmotion.helper.Navigator
import com.google.gson.Gson


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private var myAdapter: MyAdapter? = null
    private val viewModel: MainFragmentViewModel by viewModels() { VmFactory(requireContext()) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Navigator.insets(binding.root)

        initLiveDataObserver()

        myAdapter = adapterVal()

        initView()
    }

    private fun adapterVal(): MyAdapter {
        return MyAdapter() { cardList, _, pos ->
            val cardData = Gson().toJson(cardList)
            Navigator.startCardInfoContainerActivity(context, cardData, pos)
        }
    }

    private fun initLiveDataObserver() = with(binding) {
        viewModel.dataCardDetailsLiveData.observe(viewLifecycleOwner, Observer {
            myAdapter?.setCardList(it.data ?: listOf())
        })

        viewModel.isSuccessLiveData.observe(viewLifecycleOwner, Observer {
            if (!it) setToast()
        })
    }

    private fun setToast() {
        viewModel.errorLiveData.observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        })
    }

    private fun initView() = with(binding) {
        itemBgRecycle.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        itemBgRecycle.adapter = myAdapter
        buttonCards.setOnClickListener {
            val cardData = Gson().toJson(myAdapter!!.returnCardList())
            Navigator.startCardListContainerActivity(context, cardData)
        }
    }

}



