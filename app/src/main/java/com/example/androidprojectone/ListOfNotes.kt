package com.example.androidprojectone

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Spinner
import java.text.SimpleDateFormat
import java.util.*

class ListOfNotes : AppCompatActivity() {

    fun aadNote() {
        SingletonNotes.startActivity = true
        var note = Note(
            "Понедельник",
            "Забрать проект по газу",
            SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
        )
        SingletonNotes.arrayNotes.add(note)
        note = Note(
            "Среда",
            "Купить и забрать корм для кота",
            SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
        )
        SingletonNotes.arrayNotes.add(note)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_notes)

        val buttonLogout: Button = findViewById<Button>(R.id.logout_button)
        buttonLogout.setOnClickListener {
            startActivity(Intent(this, LogIn::class.java))
        }

        if (SingletonNotes.startActivity == false) {
            aadNote()
            SingletonNotes.startActivity = true
        }

        val buttonAddNew: Button = findViewById(R.id.addNewNote)
        buttonAddNew.setOnClickListener {
            startActivity(Intent(this, AddNote::class.java))
        }

        val listAdapterNote = AdapterNote(this, SingletonNotes.arrayNotes)
        findViewById<ListView>(R.id.listNote).adapter = listAdapterNote

    }
}