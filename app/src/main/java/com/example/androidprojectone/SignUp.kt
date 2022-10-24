package com.example.androidprojectone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class SignUp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        var textInputFirstName: String
        var textInputLastName: String
        var textInputEmail: String
        var textInputPassword: String
        var toast: Toast
        val minColInputChar = 5

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val buttonEnterLogin: Button = findViewById<Button>(R.id.enter_login)
        buttonEnterLogin.setOnClickListener {
            startActivity(Intent(this, LogIn::class.java))
        }

        val buttonSignUp: Button = findViewById<Button>(R.id.button_sign_up07)
        buttonSignUp.setOnClickListener {

            val firstName = findViewById<TextInputLayout>(R.id.firstName)
            textInputFirstName = firstName.editText?.text.toString()

            val lastName = findViewById<TextInputLayout>(R.id.lastName)
            textInputLastName = lastName.editText?.text.toString()

            val email = findViewById<TextInputLayout>(R.id.email)
            textInputEmail = email.editText?.text.toString()
            val isExist = "@" in textInputEmail

            val password = findViewById<TextInputLayout>(R.id.password)
            textInputPassword = password.editText?.text.toString()

            if (isExist == false) {
                toast = Toast.makeText(
                    applicationContext,
                    "email mast contain '@'",
                    Toast.LENGTH_LONG
                )
                toast.show()

            } else if (textInputEmail.length <= minColInputChar || textInputPassword.length <= minColInputChar || textInputFirstName.length == 0 || textInputLastName.length == 0) {
                toast = Toast.makeText(this, "Add correct data", Toast.LENGTH_LONG)
                toast.show()
            } else {
                startActivity(Intent(this, ListOfNotes::class.java))
            }
        }
    }
}