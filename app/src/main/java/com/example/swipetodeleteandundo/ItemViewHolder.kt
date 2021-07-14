package com.example.swipetodeleteandundo

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.swipetodeleteandundo.databinding.ItemViewBinding

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val binding: ItemViewBinding = ItemViewBinding.bind(itemView)

    fun bind(stringNumber:String){
        binding.stringNumber.text = stringNumber
    }

    fun setViewHolderNumber(number:Int){
        binding.viewHolderNumber.text = "VH № $number"
    }
}