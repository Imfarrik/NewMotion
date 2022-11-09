package com.example.myapplicationnewmotion.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplicationnewmotion.presentation.auth.AuthViewModel
import javax.inject.Inject

class MainFragmentVmFactory (val mainFragmentViewModel: MainFragmentViewModel) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainFragmentViewModel::class.java)) {
            return mainFragmentViewModel as T
        }
        throw IllegalStateException("unknown class name")
    }
}