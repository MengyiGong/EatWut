package com.example.eatwut.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.eatwut.R
import com.example.eatwut.ui.detail.DetailFragment
import com.example.eatwut.ui.main.MainFragment
import kotlinx.android.synthetic.main.add_name_fragment.add_btn
import kotlinx.android.synthetic.main.add_name_fragment.cancel_btn
import kotlinx.android.synthetic.main.add_name_fragment.clear_btn
import kotlinx.android.synthetic.main.add_name_fragment.level_spinner
import kotlinx.android.synthetic.main.add_name_fragment.name_edit_text

class AddNameFragment : Fragment() {

    companion object {
        fun newInstance() = AddNameFragment()
    }

    private lateinit var viewModel: AddNameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.add_name_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddNameViewModel::class.java)
        // use viewModel

        cancel_btn.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, MainFragment.newInstance())?.commitNow()
        }

        clear_btn.setOnClickListener {
            name_edit_text.text = null
            level_spinner.setSelection(0)
        }

        add_btn.setOnClickListener {
            // TODO: Add item in
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, DetailFragment.newInstance())?.commitNow()
        }
    }
}
