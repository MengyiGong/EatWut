package com.example.eatwut.ui.detail.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.eatwut.bean.FavoriteNamesBean
import kotlinx.android.extensions.LayoutContainer

const val TYPE_HEADER = 0
const val TYPE_ITEM = 1
const val TYPE_FOOTER = 2

abstract class DetailViewHolder(override val containerView: View) :
    RecyclerView.ViewHolder(containerView), LayoutContainer {
    abstract fun bindItem(position: Int,  favoriteName: FavoriteNamesBean)
    abstract fun bindHeader(position: Int)
    abstract fun bindFooter(position: Int)
}
