package com.example.myapplicationnewmotion.fragments

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.myapplicationnewmotion.activities.CardInfoContainerActivity
import com.example.myapplicationnewmotion.activities.MainActivity
import com.example.myapplicationnewmotion.dataModel.Data
import com.example.myapplicationnewmotion.dataModel.DataCardDetails
import com.example.myapplicationnewmotion.databinding.FragmentCardOptionsBinding
import com.example.myapplicationnewmotion.service.BankApi
import com.example.myapplicationnewmotion.service.ServiceBuilder
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CardOptionsFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentCardOptionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCardOptionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cardNumber.setOnClickListener {
            val serviceBuilder = ServiceBuilder().buildService(BankApi::class.java)
            val request = serviceBuilder.getCardsVal()

            request.enqueue(object : Callback<DataCardDetails> {
                override fun onResponse(
                    call: Call<DataCardDetails>,
                    response: Response<DataCardDetails>,
                ) {
                    if (response.isSuccessful) {
                        if (response.body() != null) {
                            Toast.makeText(context,"${response.body()}", Toast.LENGTH_LONG).show()
                        }
                    }
                }

                override fun onFailure(call: Call<DataCardDetails>, t: Throwable) {
                    Log.d("ErrorOnServer", "500")
                }
            })
        }


    }
}