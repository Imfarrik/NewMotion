package com.example.myapplicationnewmotion.presentation.bankAccountDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplicationnewmotion.presentation.auth.AuthViewModel
import javax.inject.Inject

class BankAccountDetailsVmFactory (private val bankAccountDetailsViewModel: BankAccountDetailsViewModel) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BankAccountDetailsViewModel::class.java)) {
            return bankAccountDetailsViewModel as T
        }
        throw IllegalStateException("unknown class name")
    }
}