package com.example.eatwut.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eatwut.R
import com.example.eatwut.bean.favoriteNames
import com.example.eatwut.ui.detail.adapter.DetailAdapter
import kotlinx.android.synthetic.main.detail_fragment.detail_list



class DetailFragment : Fragment() {

    companion object {
        fun newInstance() = DetailFragment()
    }

    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        detail_list.layoutManager = LinearLayoutManager(context)
        detail_list.adapter = DetailAdapter(favoriteNames, activity)
        // use viewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        detail_list.adapter = null
        favoriteNames.clear()
    }
}
