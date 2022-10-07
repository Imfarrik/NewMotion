package com.example.myapplicationnewmotion.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationnewmotion.adapter.AdapterTest
import com.example.myapplicationnewmotion.dataModel.DataCardInfo
import com.example.myapplicationnewmotion.databinding.FragmentMainBinding
import com.google.gson.Gson


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var cardList: ArrayList<DataCardInfo>
    private lateinit var cardTestAdapter: AdapterTest

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = binding.itemBgRecycle
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        cardList = ArrayList()

        cardList.add(DataCardInfo("1 256 384", "Фаррух"))
        cardList.add(DataCardInfo("4 569 328", "Шохрух"))
        cardList.add(DataCardInfo("384", "ЗП"))
        cardList.add(DataCardInfo("256 384", "Отпуск"))
        cardList.add(DataCardInfo("20 546 376", "На машину"))

        cardTestAdapter = AdapterTest(cardList)
        recyclerView.adapter = cardTestAdapter

        cardTestAdapter.onItemClick = {

            val cardData = Gson().toJson(it)
            val bundle = bundleOf("myArg" to cardData)
            Log.i("myTog", cardData)

            MainFragmentDirections.mainFragmentToCardInfoFragment().let { that ->
                findNavController().navigate(
                    that.actionId,
                    bundle
                )
            }
        }

        binding.buttonCards.setOnClickListener {
            val cardsData = Gson().toJson(cardList)
            val shareBundle = bundleOf("cardsData" to cardsData)
            Log.i("myTog", cardsData)

            MainFragmentDirections.mainFragmentToCardsFragment().let {
                findNavController().navigate(it.actionId, shareBundle)
            }
        }

//        val item: List<String> = (0..6).map { it.toString() }

//        val myAdapter = MyAdapter(item) { it, position ->
//            val gson = Gson().toJson(it)
//            val bundle = bundleOf("myArg" to it)
//
////            val intent = Intent(context, CardHolderActivity::class.java)
////            intent.putExtra("myArg", bundle)
////            startActivity(intent)
//
////            findNavController().navigate(R.id.mainFragmentToCardInfoFragment, bundle)
//
//            MainFragmentDirections.mainFragmentToCardInfoFragment().let {
//                findNavController().navigate(
//                    it.actionId,
//                    bundle
//                )
//            }
//
//        }

//        binding.itemBgRecycle.layoutManager =
//            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//
//        binding.itemBgRecycle.adapter = myAdapter

    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}