package com.example.myapplicationnewmotion.presentation.card.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.myapplicationnewmotion.databinding.FragmentViewPagerBinding
import com.example.myapplicationnewmotion.domain.apiService.model.DataCardDetailsInside
import com.example.myapplicationnewmotion.domain.room.AppDatabase
import com.example.myapplicationnewmotion.presentation.Navigator
import com.example.myapplicationnewmotion.presentation.card.info.adapter.CardInfoAdapter
import com.example.myapplicationnewmotion.presentation.custom_component.TaskPageTransformer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class CardInfoFragment : Fragment() {

    private lateinit var binding: FragmentViewPagerBinding

    @Inject
    lateinit var cardDetailedInfoDB: AppDatabase

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Navigator.insets(binding.root)

        val arg: String? = arguments?.getString(Navigator.MY_ARG)
        val argPos: Int? = arguments?.getInt(Navigator.MY_ARG_POS)
        val argData = jsonToListConverter(arg!!)

        init(arg, argPos!!, argData)

    }

    private fun jsonToListConverter(arg: String): List<DataCardDetailsInside> {
        val listType = object : TypeToken<List<DataCardDetailsInside?>?>() {}.type
        return Gson().fromJson(arg, listType)
    }

    private fun init(argListBundle: String, argPosInt: Int, argDataList: List<DataCardDetailsInside>) =
        with(binding) {

            val bankName = bankName
            val cardNumber = cardNumber
            val cardDate = cardDate
            val cardOwnerName = cardOwnerName
            val btnSettings = btnSettings
            val btnLimits = btnLimits
            val viewPager2 = viewPagerNew
            val backBtn = backButton
            val btnOperations = btnOperations

            viewPager2.let {
                it.offscreenPageLimit = 3
                it.setPageTransformer(TaskPageTransformer(0))
                (it.getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
                it.registerOnPageChangeCallback(object : OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)

                        bankName.text = argDataList[position].cardName
                        cardNumber.text = argDataList[position].cardNumber
                        cardDate.text = argDataList[position].dateExpiry
                        cardOwnerName.text = argDataList[position].embossedName

                        btnSettings.setOnClickListener {
                            navigateToCardOptionsFragment(argListBundle, position)
                        }
                        btnLimits.setOnClickListener {
                            navigateToCardListFragment()
                        }
                    }
                })
                it.adapter = CardInfoAdapter(argDataList) { _, _, _ -> }
            }

            backBtn.setOnClickListener {
                requireActivity().onBackPressedDispatcher.onBackPressed()
            }

            btnOperations.setOnClickListener {

            }

        }

    private fun navigateToCardOptionsFragment(dataString: String, dataInt: Int) {
        return findNavController().navigate(
            CardInfoFragmentDirections.actionCardInfoFragmentToCardOptionsFragment(
                dataString, dataInt
            ), Navigator.navOptions()
        )
    }

    private fun navigateToCardListFragment() {
        return findNavController().navigate(
            CardInfoFragmentDirections.actionCardInfoFragmentToLimitFragment2(),
            Navigator.navOptions()
        )
    }


}