package com.example.eatwut.ui.detail.adapter

import android.view.View
import android.widget.TextView
import com.example.eatwut.R
import com.example.eatwut.bean.FavoriteNamesBean

open class DetailItemViewHolder(
    override val containerView: View
) : DetailViewHolder(containerView) {

    private val itemName: TextView by lazy(LazyThreadSafetyMode.NONE) { containerView.findViewById<TextView>(R.id.item_name) }
    private val level: TextView by lazy(LazyThreadSafetyMode.NONE) { containerView.findViewById<TextView>(R.id.item_level) }

    override fun bindHeader(position: Int) {}

    override fun bindItem(position: Int, favoriteName: FavoriteNamesBean) {
        itemName.text = favoriteName.name
        level.text = favoriteName.level.toString()
    }

    override fun bindFooter(position: Int) {}
}
