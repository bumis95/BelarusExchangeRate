package com.android.belarusexchangerate.view.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.belarusexchangerate.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(
                R.id.fragment_container,
                DetailFragment()
            )
            .commit()
    }
}