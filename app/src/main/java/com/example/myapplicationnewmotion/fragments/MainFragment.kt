package com.example.myapplicationnewmotion.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationnewmotion.activities.ContainerActivity
import com.example.myapplicationnewmotion.adapter.MyAdapter
import com.example.myapplicationnewmotion.dataModel.DataCardInfo
import com.example.myapplicationnewmotion.databinding.FragmentMainBinding
import com.example.myapplicationnewmotion.navigator.Navigator
import com.google.gson.Gson


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
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

        val recyclerView: RecyclerView = binding.itemBgRecycle
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        val cardList: ArrayList<DataCardInfo> = ArrayList()

        cardList.add(DataCardInfo("1 256 384", "Фаррух"))
        cardList.add(DataCardInfo("4 569 328", "Шохрух"))
        cardList.add(DataCardInfo("384", "ЗП"))
        cardList.add(DataCardInfo("256 384", "Отпуск"))
        cardList.add(DataCardInfo("20 546 376", "На машину"))

        val cardData = Gson().toJson(cardList)

        val myAdapter = MyAdapter(cardList) { _, pos ->
            Navigator.startCardHolderActivity(context, cardData, pos)
        }

        recyclerView.adapter = myAdapter

        binding.buttonCards.setOnClickListener {
            Navigator.startContainerActivity(context, cardData)
        }
    }
}