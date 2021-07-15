package com.example.swipetodeleteandundo

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar


class Adapter(val mActivity: Activity, val dataSource: ArrayList<String>) :
    RecyclerView.Adapter<ItemViewHolder>() {
    companion object {
        var viewHolderCount: Int = 0
    }

    lateinit var mRecentlyDeletedItem: String
    var mRecentlyDeletedItemPosition: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val context: Context = parent.context
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_view, parent, false)
        val viewHolder = ItemViewHolder(view)

        viewHolder.setViewHolderNumber(viewHolderCount)
        viewHolderCount++

        return viewHolder
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(dataSource[position])
    }

    override fun getItemCount(): Int {
        return dataSource.size
    }

    fun deleteItem(position: Int) {
        mRecentlyDeletedItem = dataSource[position]
        mRecentlyDeletedItemPosition = position
        dataSource.removeAt(position)
        notifyItemRemoved(position)
        showUndoSnackbar()
    }

    private fun showUndoSnackbar() {
        val view: View = mActivity.findViewById(R.id.coordinator_layout)
        val snackbar: Snackbar = Snackbar.make(
            view, mActivity.getString(R.string.snack_bar_text),
            Snackbar.LENGTH_LONG
        )
        snackbar.setAction(mActivity.getString(R.string.undo)) { v -> undoDelete() }
        snackbar.show()
    }

    private fun undoDelete() {
        dataSource.add(
            mRecentlyDeletedItemPosition,
            mRecentlyDeletedItem
        )
        notifyItemInserted(mRecentlyDeletedItemPosition)
    }

}