package com.example.myapplicationnewmotion.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationnewmotion.databinding.RecycleItemCardInfoBinding

class AdapterCardInfo(
    private val value: List<String>
) : RecyclerView.Adapter<AdapterCardInfo.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val binding = RecycleItemCardInfoBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = value[position]
        holder.binding.testIdText.text = item
    }

    override fun getItemCount(): Int = value.size

    inner class MyViewHolder(val binding: RecycleItemCardInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {

//        fun initView(item: String, position: Int) {
//            itemView.setOnClickListener {
//                listener(item, position)
//            }
//        }

    }
}

