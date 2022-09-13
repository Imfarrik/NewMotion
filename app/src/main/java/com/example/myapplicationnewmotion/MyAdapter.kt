package com.example.myapplicationnewmotion

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationnewmotion.databinding.RecycleItemBinding

class MyAdapter(private val value: List<String>) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RecycleItemBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = value[position]
        holder.binding.testIdText.text = item
    }

    override fun getItemCount(): Int = value.size
}

class MyViewHolder(val binding: RecycleItemBinding) : RecyclerView.ViewHolder(binding.root)