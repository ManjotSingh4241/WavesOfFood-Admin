package com.netlifymanjot.wavesoffoodadmin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.netlifymanjot.wavesoffoodadmin.databinding.ItemItemBinding

class AddItemAdapter(
    private val MenuItemName: ArrayList<String>,
    private val MenuItemPrice: ArrayList<String>,
    private val MenuItemImage: ArrayList<Int>
) : RecyclerView.Adapter<AddItemAdapter.AddItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddItemViewHolder {
        val binding = ItemItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AddItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AddItemViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return minOf(MenuItemName.size, MenuItemPrice.size, MenuItemImage.size)
    }


    inner class AddItemViewHolder(private val binding: ItemItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                foodnameTextView.text = MenuItemName[position]
                PriceTextView.text = MenuItemPrice[position]
                foodmageView.setImageResource(MenuItemImage[position])
            }
        }

    }

}