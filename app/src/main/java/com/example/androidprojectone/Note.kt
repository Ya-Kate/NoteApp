package com.example.androidprojectone

import android.widget.EditText
import java.text.SimpleDateFormat
import java.util.*

data class Note (
    var title: String,
    var message: String,
    val nowData: String
        )