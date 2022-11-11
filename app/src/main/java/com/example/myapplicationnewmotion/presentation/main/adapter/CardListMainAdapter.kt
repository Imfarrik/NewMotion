package com.example.myapplicationnewmotion.presentation.main.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationnewmotion.domain.apiService.model.DataCardDetailsInside
import com.example.myapplicationnewmotion.databinding.RecycleItemBinding

class CardListMainAdapter(
    private val listener: (List<DataCardDetailsInside>, DataCardDetailsInside, Int) -> Unit
) :
    RecyclerView.Adapter<CardListMainAdapter.MyViewHolder>() {

    private var cardList = listOf<DataCardDetailsInside>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RecycleItemBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val card = cardList[position]
        holder.initView(cardList, card, position)
    }

    override fun getItemCount(): Int = cardList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setCardList(data: List<DataCardDetailsInside>) {
        this.cardList = data
        notifyDataSetChanged()
    }

    fun returnCardList(): List<DataCardDetailsInside> {
        return cardList
    }

    inner class MyViewHolder(val binding: RecycleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun initView(listData: List<DataCardDetailsInside>, item: DataCardDetailsInside, position: Int) {
            itemView.setOnClickListener {
                listener(listData, item, position)

            }
            binding.cardBalance.text = item.cardBalance.toString()
            binding.testIdText.text = item.cardName
        }

    }

}
