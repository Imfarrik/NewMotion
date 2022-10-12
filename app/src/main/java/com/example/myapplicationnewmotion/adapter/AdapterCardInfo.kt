package com.example.myapplicationnewmotion.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationnewmotion.dataModel.DataCardInfo
import com.example.myapplicationnewmotion.databinding.RecycleItemCardInfoBinding

class AdapterCardInfo(
    private val value: ArrayList<DataCardInfo>, private val listener: (DataCardInfo, Int) -> Unit
) : RecyclerView.Adapter<AdapterCardInfo.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val binding = RecycleItemCardInfoBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = value[position]
        holder.balance.text = item.cardBalance
        holder.disc.text = item.cardDescription

        holder.initView(item, position)
    }

    override fun getItemCount(): Int = value.size


    inner class MyViewHolder(val binding: RecycleItemCardInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val balance = binding.cardBalance
        val disc = binding.testIdText

        fun initView(item:DataCardInfo, position: Int) {
            itemView.setOnClickListener {
                listener(item, position)
            }
        }

    }
}

