package com.example.myapplicationnewmotion.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationnewmotion.R
import com.example.myapplicationnewmotion.dataModel.DataCardInfo
import com.example.myapplicationnewmotion.databinding.RecycleItemBinding

class AdapterTest(private val cardList: ArrayList<DataCardInfo>) :
    RecyclerView.Adapter<AdapterTest.AdapterTestHolder>() {

    var onItemClick : ((DataCardInfo) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterTestHolder {
        val binding = RecycleItemBinding.inflate(LayoutInflater.from(parent.context))
        return AdapterTestHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterTestHolder, position: Int) {
        val card = cardList[position]
        holder.cardBalance.text = card.cardBalance
        holder.cardDescription.text = card.cardDescription

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(card)
        }
    }

    override fun getItemCount(): Int = cardList.size

    class AdapterTestHolder(val binding: RecycleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val cardBalance: TextView = binding.cardBalance
        val cardDescription: TextView = binding.testIdText
    }

}