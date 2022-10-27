package com.example.androidprojectone

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputLayout
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
            val picker:DatePicker = findViewById<DatePicker>(R.id.calendarView)
            val stringData:String = SingletonStringData.getData(picker)

            val note = Note(
                buttonTitle.editText?.text.toString(),
                buttonMessage.editText?.text.toString(),
                stringData
            )
            SingletonNotes.arrayNotes.add(note)
            startActivity(Intent(this, this::class.java))
        }




    }

}



