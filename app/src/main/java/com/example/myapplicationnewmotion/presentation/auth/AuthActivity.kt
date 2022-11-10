package com.example.myapplicationnewmotion.presentation.auth

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.myapplicationnewmotion.databinding.ActivityAuthBinding
import com.example.myapplicationnewmotion.presentation.Navigator

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding

    private val viewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)

        setContentView(binding.root)

        insets()
        initView()
        initLiveDataObservers()
    }

    private fun insets() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        Navigator.insets(binding.root)
    }

    private fun initView() = with(binding) {

        btnAutoFill.setOnClickListener {
            viewModel.onAutoFillClicked()
        }

        btnSignIn.setOnClickListener {
            val login = login.text.toString()
            val password = password.text.toString()
            when {
                login.isBlank() -> setToast("Заполните поле \"логин\"")
                password.isBlank() -> setToast("Заполните поле \"пароль\"")
                login.isNotBlank() && password.isNotBlank() -> {
                    viewModel.onSignInClicked(login, password)
                }
            }
        }
    }

    private fun initLiveDataObservers() {
        viewModel.progressLiveData.observe(this) {
            progressBar(it)
        }

        viewModel.getTokenLiveData.observe(this) {
            Navigator.startMainActivity(this)
        }

        viewModel.errorLiveData.observe(this) {
            setToast(it)
        }
    }

    private fun progressBar(visibility: Boolean) = with(binding) {
        if (!visibility) {
            this.progressBar.visibility = View.GONE
            this.btnSignIn.isEnabled = true
            this.btnAutoFill.isEnabled = true
        } else {
            this.progressBar.visibility = View.VISIBLE
            this.btnSignIn.isEnabled = false
            this.btnAutoFill.isEnabled = false
        }
    }

    private fun setToast(text: String?) {
        Toast.makeText(this@AuthActivity, text, Toast.LENGTH_SHORT).show()
    }

}