package com.example.myapplicationnewmotion.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationnewmotion.databinding.RecycleItemBinding

class MyAdapter(private val value: List<String>, private val listener: (String, Int) -> Unit) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RecycleItemBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = value[position]
        holder.binding.testIdText.text = item
        holder.initView(item, position)
    }

    override fun getItemCount(): Int = value.size

    inner class MyViewHolder(val binding: RecycleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun initView(item: String, position: Int) {
            itemView.setOnClickListener {
                listener(item, position)
            }
        }

    }

}
