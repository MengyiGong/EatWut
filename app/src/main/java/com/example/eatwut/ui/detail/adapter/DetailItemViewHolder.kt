package com.example.eatwut.ui.detail.adapter

import android.view.View
import android.widget.TextView
import com.example.eatwut.R
import com.example.eatwut.bean.favoriteNames

open class DetailItemViewHolder(
    override val containerView: View
) : DetailViewHolder(containerView) {

    private val itemName: TextView by lazy(LazyThreadSafetyMode.NONE) { containerView.findViewById<TextView>(R.id.item_name) }
    private val level: TextView by lazy(LazyThreadSafetyMode.NONE) { containerView.findViewById<TextView>(R.id.item_level) }

    override fun bindHeader(position: Int) {}

    override fun bindItem(position: Int) {
        itemName.text = favoriteNames[position].name
        level.text = favoriteNames[position].level.toString()
    }

    override fun bindFooter(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
