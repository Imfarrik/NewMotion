package com.example.myapplicationnewmotion.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationnewmotion.dataModel.DataCardInfo
import com.example.myapplicationnewmotion.databinding.RecycleItemBinding

class MyAdapter(
    private val cardList: ArrayList<DataCardInfo>,
    private val listener: (DataCardInfo, Int) -> Unit
) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RecycleItemBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val card = cardList[position]
        holder.cardBalance.text = card.cardBalance
        holder.cardDescription.text = card.cardDescription

        holder.initView(card, position)
    }

    override fun getItemCount(): Int = cardList.size

    inner class MyViewHolder(val binding: RecycleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val cardBalance: TextView = binding.cardBalance
        val cardDescription: TextView = binding.testIdText

        fun initView(item: DataCardInfo, position: Int) {
            itemView.setOnClickListener {
                listener(item, position)
            }
        }

    }

}
