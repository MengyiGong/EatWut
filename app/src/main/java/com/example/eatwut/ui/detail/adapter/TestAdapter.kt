package com.example.eatwut.ui.detail.adapter

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eatwut.R
import com.example.eatwut.bean.favoriteNames

class TestAdapter : RecyclerView.Adapter<TestAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemView =  LayoutInflater.from(parent.context)
            .inflate(R.layout.item_detail_view, parent, false)
        return ViewHolder(itemView)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(position)
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return favoriteNames.size
    }


    //the class is holding the list view
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(position: Int) {
            val itemName = itemView.findViewById<TextView>(R.id.item_name)
            val level = itemView.findViewById<TextView>(R.id.item_level)
            itemName.text = favoriteNames[position].name
            level.text = favoriteNames[position].level.toString()
        }
    }
}