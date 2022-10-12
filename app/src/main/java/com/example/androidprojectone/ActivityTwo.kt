package com.example.androidprojectone

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

/**
 * Loads [MainFragment].
 */
class ActivityTwo : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

    }
}