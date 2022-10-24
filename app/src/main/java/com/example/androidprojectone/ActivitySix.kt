package com.example.androidprojectone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ActivitySix : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_six)

        val buttonSkip = findViewById<Button>(R.id.skip_activitySix)
        buttonSkip.setOnClickListener {
            startActivity(Intent(this,LogIn::class.java))
        }
    }
}