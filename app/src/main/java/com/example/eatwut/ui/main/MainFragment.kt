package com.example.eatwut.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.BounceInterpolator
import android.view.animation.TranslateAnimation
import androidx.fragment.app.FragmentManager
import com.example.eatwut.R
import com.example.eatwut.ui.detail.DetailFragment
import kotlinx.android.synthetic.main.main_fragment.result_name
import kotlinx.android.synthetic.main.main_fragment.see_list
import kotlinx.android.synthetic.main.main_fragment.start_btn

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        start_btn.setOnClickListener {
            result_name.text = viewModel.getName()
        }
        see_list.setOnClickListener {
            //TODO: Figure out the back stack
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, DetailFragment.newInstance(), "")?.commitNow()
        }
    }

    override fun onStart() {
        super.onStart()
        jumpingStartBtn()
    }

    private fun jumpingStartBtn() {
        val down =
            TranslateAnimation(0F, 0F, -600F, 0F)//位移动画，从button的上方300像素位置开始
        down.fillAfter = true
        down.interpolator = BounceInterpolator()//弹跳动画,要其它效果的当然也可以设置为其它的值
        down.duration = 2000//持续时间
        start_btn.startAnimation(down)//设置按钮运行该动画效果
    }
}
