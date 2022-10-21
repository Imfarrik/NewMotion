package com.example.myapplicationnewmotion.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
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
import com.example.myapplicationnewmotion.dataModel.DataCardInfo
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

        val recyclerView: RecyclerView = binding.itemBgRecycle
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        val cardList: ArrayList<DataCardInfo> = ArrayList<DataCardInfo>()
        Log.i("MyTag", "$cardList")

//        cardList.add(DataCardInfo("1 256 384", "Фаррух"))
//        cardList.add(DataCardInfo("4 569 328", "Шохрух"))
//        cardList.add(DataCardInfo("384", "ЗП"))
//        cardList.add(DataCardInfo("256 384", "Отпуск"))
//        cardList.add(DataCardInfo("20 546 376", "На машину"))


        val cardData = Gson().toJson(cardList)

        val myAdapter = MyAdapter(cardList) { _, pos ->
            Navigator.startCardInfoContainerActivity(context, cardData, pos)
        }

        recyclerView.adapter = myAdapter

        binding.buttonCards.setOnClickListener {
            Navigator.startCardListContainerActivity(context, cardData)
        }
    }

    private fun loadDataFromServer() {
        val serviceBuilder = ServiceBuilder().buildService(BankApi::class.java)
        val request = serviceBuilder.getCardsVal()

        request.enqueue(object : Callback<DataCardDetails> {
            override fun onResponse(
                call: Call<DataCardDetails>,
                response: Response<DataCardDetails>
            ) {
                if (response.isSuccessful) {
                    val item = response.body()
                    val b: ArrayList<Data>? = item?.data
                    if (b != null) {
                        for (i in b.indices) {
                            val card = b[i]
                            val some = DataCardInfo(card.cardBalance.toString(), card.cardName)
//                            a.add(some)
                        }
                    }

                }
            }

            override fun onFailure(call: Call<DataCardDetails>, t: Throwable) {
                Log.d("ErrorOnServer", "500")
            }
        })
    }

    private fun parseData(result: DataCardDetails?): ArrayList<DataCardInfo> {
        val a: ArrayList<DataCardInfo> = ArrayList()
        val b: ArrayList<Data> = result?.data as ArrayList<Data>
        for (i in b.indices) {
            val card = b[i]
            val some = DataCardInfo(card.cardBalance.toString(), card.cardName)
            a.add(some)
        }
        return a
    }

}

//fun main() {
////    val a = loadDataFromServer()
//    println(loadDataFromServer())
//}
//
//fun loadDataFromServer(): ArrayList<DataCardInfo> {
//    val serviceBuilder = ServiceBuilder().buildService(BankApi::class.java)
//    val request = serviceBuilder.getCardsVal()
//    var a: ArrayList<DataCardInfo> = ArrayList()
//
//    request.enqueue(object : Callback<DataCardDetails> {
//        override fun onResponse(
//            call: Call<DataCardDetails>,
//            response: Response<DataCardDetails>
//        ) {
//            if (response.isSuccessful) {
//                val item = response.body()
//                val b: ArrayList<Data> = item?.data as ArrayList<Data>
//                for (i in b.indices) {
//                    val card = b[i]
//                    val some = DataCardInfo(card.cardBalance.toString(), card.cardName)
//                    a.add(some)
//                }
//            }
//        }
//
//        override fun onFailure(call: Call<DataCardDetails>, t: Throwable) {
//            Log.d("ErrorOnServer", "500")
//        }
//    })
//    return a
//
//}


