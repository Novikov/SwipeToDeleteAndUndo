package com.example.swipetodeleteandundo

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(val dataSource: ArrayList<String>) : RecyclerView.Adapter<ItemViewHolder>(){
    companion object{
        var viewHolderCount:Int = 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val context: Context = parent.context
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_view,parent,false)
        val viewHolder = ItemViewHolder(view)

        viewHolder.setViewHolderNumber(viewHolderCount)
        viewHolderCount++

        return viewHolder
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(dataSource.get(position))
    }

    override fun getItemCount(): Int {
        return dataSource.size
    }

}