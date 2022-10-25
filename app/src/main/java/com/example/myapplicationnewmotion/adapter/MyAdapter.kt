package com.example.myapplicationnewmotion.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationnewmotion.dataModel.Data
import com.example.myapplicationnewmotion.databinding.RecycleItemBinding

class MyAdapter(
    private val listener: (List<Data>, Data, Int) -> Unit
) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var cardList = listOf<Data>()

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
    fun setCardList(data: List<Data>) {
        this.cardList = data
        notifyDataSetChanged()
    }

    fun returnCardList(): List<Data> {
        return cardList
    }

    fun balance(): String {
        var a = 0
        val b = returnCardList()
        for (i in b.indices) {
            a += b[i].cardBalance
        }
        return a.toString()
    }

    inner class MyViewHolder(val binding: RecycleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun initView(listData: List<Data>, item: Data, position: Int) {
            itemView.setOnClickListener {
                listener(cardList, item, position)

            }
            binding.cardBalance.text = item.cardBalance.toString()
            binding.testIdText.text = item.cardName
        }

    }

}
