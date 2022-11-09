package com.example.myapplicationnewmotion.unUsed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplicationnewmotion.presentation.auth.AuthViewModel
import com.example.myapplicationnewmotion.presentation.bankAccountDetails.BankAccountDetailsViewModel
import com.example.myapplicationnewmotion.presentation.cardOptionsDialog.CardOptionsViewModel
import com.example.myapplicationnewmotion.presentation.main.MainFragmentViewModel
import javax.inject.Inject

class VmFactory @Inject constructor(
    val viewModel: ViewModel
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val vModel = when (modelClass) {
            AuthViewModel::class.java -> {
                viewModel
            }
            MainFragmentViewModel::class.java -> {
                viewModel
            }
            BankAccountDetailsViewModel::class.java -> {
                viewModel
            }
            CardOptionsViewModel::class.java -> {
                viewModel
            }
            else -> {
                throw IllegalStateException("Unknown ViewModel Class")
            }
        }
        return vModel as T
    }

}