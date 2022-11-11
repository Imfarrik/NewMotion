package com.example.myapplicationnewmotion.presentation.card.info.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplicationnewmotion.databinding.FragmentCardOptionsBinding
import com.example.myapplicationnewmotion.domain.apiService.model.DataCardDetailsInside
import com.example.myapplicationnewmotion.presentation.Navigator
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CardActionDialogFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentCardOptionsBinding
    private val viewModel: CardActionDialogViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentCardOptionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arg = arguments?.getString(Navigator.MY_ARG)
        val argPos = arguments?.getInt(Navigator.MY_ARG_POS)
        val dataList = getBundleArrayData(arg!!)
        val cardData = dataList[argPos!!]

        Navigator.insets(binding.root)

        initView(cardData, arg, argPos)

    }

    private fun initView(cardData: DataCardDetailsInside, arg: String, argPos: Int) = with(binding) {
        cardNumber.setOnClickListener {
            toast(cardData.cardNumber!!)
        }
        cardInfo.setOnClickListener {
            findNavController().navigate(
                CardActionDialogFragmentDirections.actionCardOptionsToBankAccountDetailsFragment(arg, argPos),
                Navigator.navOptions()
            )
        }
        deleteCard.setOnClickListener {
            viewModel.removeCardById(cardData.cardId!!)
            setToast()
        }
        blockCard.setOnClickListener {
            updateCardsValStatusCard(cardData.cardId!!)
        }
        smsInfo.setOnClickListener {
            updateCardsSmsServiceState(cardData.cardId!!, 911311555)
        }
        editCard.setOnClickListener {
            //TODO: Set a logic
        }


    }

    private fun getBundleArrayData(arg: String): List<DataCardDetailsInside> {
        val listType = object : TypeToken<List<DataCardDetailsInside?>?>() {}.type
        return Gson().fromJson(arg, listType)
    }

    private fun updateCardsValStatusCard(cardId: Int) {

        val value = mapOf<String, Any>("cardId" to cardId, "stateName" to "Blocked")

        viewModel.updateCardStatus(value)
        setToast()
    }

    private fun updateCardsSmsServiceState(id: Int, phoneNum: Int) {

        val value = mapOf<String, Any>("cardId" to id, "smsServiceState" to phoneNum)

        viewModel.updatePhoneNumber(value)
        setToast()
    }

    private fun toast(value: String) {
        Toast.makeText(requireContext(), value, Toast.LENGTH_SHORT).show()
    }

    private fun setToast() {
        viewModel.textLiveData.observe(viewLifecycleOwner) {
            toast(it)
        }
    }

}