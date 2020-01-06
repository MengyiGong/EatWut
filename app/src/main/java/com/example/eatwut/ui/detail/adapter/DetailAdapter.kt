package com.example.eatwut.ui.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eatwut.R
import com.example.eatwut.bean.FavoriteNamesBean
import com.example.eatwut.bean.favoriteNames

class DetailAdapter(
    val favoriteNames: MutableList<FavoriteNamesBean>
) : RecyclerView.Adapter<DetailViewHolder>() {

    var recyclerView: RecyclerView? = null

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        this.recyclerView = recyclerView
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        recyclerView.removeAllViews()
        this.recyclerView = null
    }
    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DetailViewHolder {
        return when (viewType) {
            TYPE_HEADER -> {
                val view =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.add_item_view, parent, false)
                DetailAddItemButtonViewHolder(view)
            }
            else -> {
                val view =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_detail_view, parent, false)
                DetailItemViewHolder(view)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> TYPE_HEADER
            else -> TYPE_ITEM
        }
    }

    override fun getItemCount(): Int {
        return favoriteNames.size + 1
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        when (holder) {
            is DetailAddItemButtonViewHolder ->
                holder.bindHeader(position)
            is DetailItemViewHolder ->
                holder.bindItem(position, favoriteNames[position - 1])
        }
    }

    open fun updateData() {
        recyclerView?.post {
            notifyDataSetChanged()
        }
    }
}