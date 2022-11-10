package com.example.myapplicationnewmotion.presentation.bankAccountDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapplicationnewmotion.databinding.FragmentBankAccountDetailsBinding
import com.example.myapplicationnewmotion.domain.Navigator
import com.example.myapplicationnewmotion.model.data.Data

class BankAccountDetailsFragment : Fragment() {

    private lateinit var binding: FragmentBankAccountDetailsBinding
    private val viewModel: BankAccountDetailsViewModel by viewModels()

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

    private fun initView(data: List<Data>, pos: Int) = with(binding) {
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