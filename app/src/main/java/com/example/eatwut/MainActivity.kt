package com.example.eatwut

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.eatwut.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance(), "MainFragment")
                .commitNow()
        }
    }

    override fun onBackPressed() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MainFragment.newInstance())
            .commitNow()
//        //TODO: Figure out the back stack
//        if (supportFragmentManager.backStackEntryCount > 0) {
//            supportFragmentManager.popBackStackImmediate()
//        } else {
//            super.onBackPressed()
//        }
    }

}
