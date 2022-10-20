package com.example.androidprojectone

import android.content.Intent
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val buttonDiscover: Button = findViewById<Button>(R.id.button_discover_the_platform)
        buttonDiscover.setOnClickListener {
            startActivity(Intent(this, ActivityTwo::class.java))

            Thread {
                try {
                    Thread.sleep(2000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                val i = Intent(this, ActivityThree::class.java)
                startActivity(i)
            }.start()

            Thread {
                try {
                    Thread.sleep(5000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                val i = Intent(this, ActivityFour::class.java)
                startActivity(i)
            }.start()

            Thread {
                try {
                    Thread.sleep(8000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                val i = Intent(this, ActivityFive::class.java)
                startActivity(i)
            }.start()

            Thread {
                try {
                    Thread.sleep(11000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                val i = Intent(this, ActivitySix::class.java)
                startActivity(i)
            }.start()
        }

        val buttonLogIn: Button = findViewById<Button>(R.id.have_account_login)
        buttonLogIn.setOnClickListener {
            startActivity(Intent(this, LogIn::class.java))
        }
    }
}