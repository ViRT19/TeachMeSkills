package com.example.leson20

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.leson20.databinding.ItemBinding

class MyAdapter(val listOfItems: MutableList<String>) : RecyclerView.Adapter<MyAdapter.MyHolder>() {

    class MyHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: String) {
            binding.textCard.text = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MyHolder,
        position: Int
    ) {
        holder.onBind(listOfItems[position])
    }


    override fun getItemCount(): Int {
        return listOfItems.size
    }
}
