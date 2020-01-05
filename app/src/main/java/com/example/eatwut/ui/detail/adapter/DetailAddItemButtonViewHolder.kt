package com.example.eatwut.ui.detail.adapter

import android.view.View
import android.widget.TextView
import com.example.eatwut.R

open class DetailAddItemButtonViewHolder(
    override val containerView: View
) : DetailViewHolder(containerView) {

    val addBtn: TextView by lazy(LazyThreadSafetyMode.NONE) { containerView.findViewById<TextView>(R.id.add_more_item) }

    override fun bindHeader(position: Int) {
        addBtn.setOnClickListener {

        }
    }

    override fun bindItem(position: Int) {

    }

    override fun bindFooter(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
