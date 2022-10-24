package com.example.androidprojectone

import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import java.sql.Date
import java.text.SimpleDateFormat
import java.util.*


class AddNote : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        val buttonBack: Button = findViewById<Button>(R.id.back)
        buttonBack.setOnClickListener {
            startActivity(Intent(this, ListOfNotes::class.java))
        }

        val buttonAddnote = findViewById<Button>(R.id.addNote)
        buttonAddnote.setOnClickListener {
            val buttonTitle = findViewById<TextInputLayout>(R.id.title)
            val buttonMessage = findViewById<TextInputLayout>(R.id.message)
            val note = Note(
                buttonTitle.editText?.text.toString(),
                buttonMessage.editText?.text.toString(),
                SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
            )
            SingletonNotes.arrayNotes.add(note)
            startActivity(Intent(this, this::class.java))
        }
    }
}