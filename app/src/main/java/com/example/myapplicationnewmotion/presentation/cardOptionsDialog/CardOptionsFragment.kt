package com.example.myapplicationnewmotion.presentation.cardOptionsDialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplicationnewmotion.databinding.FragmentCardOptionsBinding
import com.example.myapplicationnewmotion.di.App
import com.example.myapplicationnewmotion.domain.Navigator
import com.example.myapplicationnewmotion.model.data.Data
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class CardOptionsFragment : BottomSheetDialogFragment() {

    @Inject
    lateinit var vmFactory: CardOptionsVmFactory
    private lateinit var binding: FragmentCardOptionsBinding
    private val viewModel: CardOptionsViewModel by viewModels { vmFactory }

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

        (activity?.applicationContext as App).appComponent.inject(this)

        Navigator.insets(binding.root)

        initView(cardData, arg, argPos)

    }

    private fun initView(cardData: Data, arg: String, argPos: Int) = with(binding) {
        cardNumber.setOnClickListener {
            toast(cardData.cardNumber!!)
        }
        cardInfo.setOnClickListener {
            findNavController().navigate(
                CardOptionsFragmentDirections.actionCardOptionsToBankAccountDetailsFragment(arg, argPos),
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

    private fun getBundleArrayData(arg: String): List<Data> {
        val listType = object : TypeToken<List<Data?>?>() {}.type
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