package com.example.androidprojectone

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class LogIn : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        var textInputEmail: String
        var textInputLogin: String
        var toast: Toast
        val colInputChar = 5
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        val returnSign: Button = findViewById<Button>(R.id.return_sign)
        returnSign.setOnClickListener {
            startActivity(Intent(this, SignUp::class.java))
        }


        val buttonLogIn: Button = findViewById<Button>(R.id.button_log_in21)
        buttonLogIn.setOnClickListener {

            val login = findViewById<TextInputLayout>(R.id.password21)
            textInputLogin = login.editText?.text.toString()

            val email = findViewById<TextInputLayout>(R.id.email21)
            textInputEmail = email.editText?.text.toString()
            val isExist = "@" in textInputEmail

            if (isExist == false) {
                toast = Toast.makeText(
                    applicationContext,
                    "email mast contain '@'",
                    Toast.LENGTH_LONG
                )
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()

            } else if (textInputLogin.length <= colInputChar || textInputEmail.length <= colInputChar) {

                toast = Toast.makeText(
                    applicationContext,
                    "wrong password or email",
                    Toast.LENGTH_LONG
                )
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
            } else {
                startActivity(Intent(this, ListOfNotes::class.java))
            }
        }
    }
}