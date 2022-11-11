package com.example.myapplicationnewmotion.presentation.card.requisite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapplicationnewmotion.databinding.FragmentBankAccountDetailsBinding
import com.example.myapplicationnewmotion.domain.apiService.model.DataCardDetailsInside
import com.example.myapplicationnewmotion.presentation.Navigator

class CardRequisiteFragment : Fragment() {

    private lateinit var binding: FragmentBankAccountDetailsBinding
    private val viewModel: CardRequisiteViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentBankAccountDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Navigator.insets(binding.root)

        val argPos = arguments?.getInt(Navigator.MY_ARG_POS)

        initLiveDataObserver(argPos!!)

        setToast()
    }

    private fun initLiveDataObserver(pos: Int) {
        viewModel.dataCardDetailsLiveData.observe(viewLifecycleOwner) {
            initView(it, pos)
        }
    }

    private fun initView(data: List<DataCardDetailsInside>, pos: Int) = with(binding) {
        cardOwnerName.text = data[pos].embossedName
        mfo.text = data[pos].filialCode
        longAccountNumber.text = data[pos].cardAccount
        btnClosePageCardOptions.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun setToast() {
        viewModel.errorLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
    }

}