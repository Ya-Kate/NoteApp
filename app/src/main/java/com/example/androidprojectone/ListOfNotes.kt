package com.example.androidprojectone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView

class ListOfNotes : AppCompatActivity() {

    fun aadNote() {
        SingletonNotes.startActivity = true
        var note = Note(
            "Понедельник",
            "Забрать проект по газу",
            "12.11.2022"
        )
        SingletonNotes.arrayNotes.add(note)
        note = Note(
            "Среда",
            "Купить и забрать корм для кота",
            "10.10.2022"
        )
        SingletonNotes.arrayNotes.add(note)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_notes)

        val buttonLogout: Button = findViewById<Button>(R.id.logout_button)
        buttonLogout.setOnClickListener {

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