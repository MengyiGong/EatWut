package com.example.eatwut.ui.detail.adapter

import android.view.View
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.example.eatwut.R
import com.example.eatwut.bean.FavoriteNamesBean
import com.example.eatwut.ui.add.AddNameFragment


open class DetailAddItemButtonViewHolder(
    override val containerView: View,
    activity: FragmentActivity?
) : DetailViewHolder(containerView) {
    private val addBtn: TextView by lazy(LazyThreadSafetyMode.NONE) { containerView.findViewById<TextView>(R.id.add_more_item) }
    private val activityA = activity

    override fun bindHeader(position: Int) {
        addBtn.setOnClickListener {
            activityA?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, AddNameFragment.newInstance(), "")?.commitNow()
        }
    }

    override fun bindItem(position: Int, favoriteName: FavoriteNamesBean) {}

    override fun bindFooter(position: Int) {}
}
