package com.example.myapplicationnewmotion.presentation.card.info.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationnewmotion.domain.apiService.model.DataCardDetailsInside
import com.example.myapplicationnewmotion.databinding.RecycleItemForViewPagerBinding

class CardInfoAdapter(
    private val listData: List<DataCardDetailsInside>,
    val listener: (List<DataCardDetailsInside>, DataCardDetailsInside, Int) -> Unit
) :
    RecyclerView.Adapter<CardInfoAdapter.PagerHolder>() {

    inner class PagerHolder(val binding: RecycleItemForViewPagerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun init(listData: List<DataCardDetailsInside>, item: DataCardDetailsInside, position: Int) {
            itemView.setOnClickListener {
                listener(listData, item, position)
            }
            binding.cardBalance.text = item.cardBalance.toString()
            binding.cardNumber.text = item.cardNumber
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerHolder {
        val binding = RecycleItemForViewPagerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PagerHolder(binding)
    }

    override fun onBindViewHolder(holder: PagerHolder, position: Int) {
        val cardList = listData[position]
        holder.init(listData, cardList, position)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

}