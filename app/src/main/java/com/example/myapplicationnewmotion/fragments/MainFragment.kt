package com.example.myapplicationnewmotion.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationnewmotion.adapter.MyAdapter
import com.example.myapplicationnewmotion.dataModel.DataCardInfo
import com.example.myapplicationnewmotion.databinding.FragmentMainBinding
import com.example.myapplicationnewmotion.navigator.Navigator
import com.example.myapplicationnewmotion.navigator.navigator
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

        navigator().insets(binding.root)

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
//            Navigator.startCardHolderActivity(context, cardData, pos)
            val bundlePostA = bundleOf(Navigator.MY_ARG to cardData, Navigator.MY_ARG_POS to pos)
            MainFragmentDirections.mainFragmentToCardInfoFragment().let { that ->
                findNavController().navigate(
                    that.actionId,
                    bundlePostA,
                    NavOptions.Builder()
                        .setEnterAnim(androidx.appcompat.R.anim.abc_slide_in_bottom)
                        .setExitAnim(androidx.appcompat.R.anim.abc_fade_out)
                        .setPopEnterAnim(androidx.appcompat.R.anim.abc_slide_in_bottom)
                        .setPopExitAnim(androidx.appcompat.R.anim.abc_fade_out)
                        .build()
                )
            }
        }

        recyclerView.adapter = myAdapter

        binding.buttonCards.setOnClickListener {
//            Navigator.startContainerActivity(context, cardData)
            val bundlePost = bundleOf(Navigator.CARDS_DATA to cardData)
            MainFragmentDirections.mainFragmentToCardsFragment().let { that ->
                findNavController().navigate(
                    that.actionId,
                    bundlePost,
                    NavOptions.Builder()
                        .setEnterAnim(androidx.appcompat.R.anim.abc_slide_in_bottom)
                        .setExitAnim(androidx.appcompat.R.anim.abc_fade_out)
                        .setPopEnterAnim(androidx.appcompat.R.anim.abc_slide_in_bottom)
                        .setPopExitAnim(androidx.appcompat.R.anim.abc_fade_out)
                        .build()
                )
            }
        }
    }

    override fun onResume() {
        super.onResume()
        navigator().hideBottomNavBar(false)
    }

    override fun onPause() {
        super.onPause()
        navigator().hideBottomNavBar(true)
    }

}