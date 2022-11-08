package com.example.myapplicationnewmotion.helper

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplicationnewmotion.dataModel.service.SessionManager
import com.example.myapplicationnewmotion.helper.apiService.ApiServiceImpl
import com.example.myapplicationnewmotion.presentation.auth.AuthViewModel
import com.example.myapplicationnewmotion.presentation.bankAccountDetails.BankAccountDetailsViewModel
import com.example.myapplicationnewmotion.presentation.cardOptionsDialog.CardOptionsViewModel
import com.example.myapplicationnewmotion.presentation.main.MainFragmentViewModel

class VmFactory(
    private val context: Context
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val vModel = when (modelClass) {
            AuthViewModel::class.java -> {
                AuthViewModel(SessionManager(context), ApiServiceImpl(context))
            }
            MainFragmentViewModel::class.java -> {
                MainFragmentViewModel(ApiServiceImpl(context))
            }
            BankAccountDetailsViewModel::class.java -> {
                BankAccountDetailsViewModel(ApiServiceImpl(context))
            }
            CardOptionsViewModel::class.java -> {
                CardOptionsViewModel(ApiServiceImpl(context))
            }
            else -> {
            throw IllegalStateException("Unknown ViewModel Class")
            }
        }
        return vModel as T
    }

}