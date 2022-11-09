package com.example.myapplicationnewmotion.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplicationnewmotion.presentation.auth.AuthViewModel
import javax.inject.Inject

class AuthVmFactory (val authViewModel: AuthViewModel) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AuthViewModel::class.java)) {
            return authViewModel as T
        }
        throw IllegalStateException("unknown class name")
    }
}