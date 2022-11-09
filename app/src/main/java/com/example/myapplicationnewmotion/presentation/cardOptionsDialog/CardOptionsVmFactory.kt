package com.example.myapplicationnewmotion.presentation.cardOptionsDialog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplicationnewmotion.presentation.auth.AuthViewModel
import javax.inject.Inject

class CardOptionsVmFactory (private val cardOptionsViewModel: CardOptionsViewModel) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CardOptionsViewModel::class.java)) {
            return cardOptionsViewModel as T
        }
        throw IllegalStateException("unknown class name")
    }
}