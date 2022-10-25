package com.example.myapplicationnewmotion.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationnewmotion.adapter.MyAdapter
import com.example.myapplicationnewmotion.dataModel.Data
import com.example.myapplicationnewmotion.dataModel.DataCardDetails
import com.example.myapplicationnewmotion.databinding.FragmentMainBinding
import com.example.myapplicationnewmotion.navigator.Navigator
import com.example.myapplicationnewmotion.service.BankApi
import com.example.myapplicationnewmotion.service.ServiceBuilder
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private var myAdapter: MyAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Navigator.insets(binding.root)

        loadDataFromServer()

        myAdapter = MyAdapter() { cardList, _, pos ->
            val cardData = Gson().toJson(cardList)
            Navigator.startCardInfoContainerActivity(context, cardData, pos)
        }


        binding.let {
            it.itemBgRecycle.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            it.itemBgRecycle.adapter = myAdapter
            it.buttonCards.setOnClickListener{
                val a = myAdapter!!.returnCardList()
                val cardData = Gson().toJson(a)
                Navigator.startCardListContainerActivity(context, cardData)
            }
        }
    }

    private fun loadDataFromServer() {
        val serviceBuilder = ServiceBuilder().buildService(BankApi::class.java)
        val request = serviceBuilder.getCardsVal()

        request.enqueue(object : Callback<DataCardDetails> {
            override fun onResponse(
                call: Call<DataCardDetails>,
                response: Response<DataCardDetails>,
            ) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        val cardList = response.body()?.data
                        myAdapter?.setCardList(cardList ?: listOf())
                    }
                }
            }

            override fun onFailure(call: Call<DataCardDetails>, t: Throwable) {
                Log.d("ErrorOnServer", "500")
            }
        })
    }
}



