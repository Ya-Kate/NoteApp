package com.example.androidprojectone

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class AdapterNote(val context: Context, var list: ArrayList<Note>) : BaseAdapter() {
//    private lateinit var mListener:onClickListener
//    interface onClickListener {
//        fun onItemClick (position: Int)
//    }
//    fun setItemOnClickListener() {
//
//    }

    override fun getCount() = list.size

    override fun getItem(position: Int) = list[position]

    override fun getItemId(position: Int) = position.toLong()


   override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val dateString = list[position].nowData
        val formatter = SimpleDateFormat("dd.MM.yyyy")
        val date = formatter.parse(dateString)
        val dataStringNow = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(Date())
        val dataNow = formatter.parse(dataStringNow)



        var rowItem: View =
            LayoutInflater.from(context).inflate(R.layout.item_note, parent, false)

        rowItem.findViewById<TextView>(R.id.title).text = getItem(position).title
        rowItem.findViewById<TextView>(R.id.message).text = getItem(position).message
        rowItem.findViewById<TextView>(R.id.time).text = getItem(position).nowData

        val cmp = date.compareTo(dataNow)
        when {
            cmp > 0 -> {
                rowItem =
                    LayoutInflater.from(context).inflate(R.layout.item_note_will, parent, false)

                rowItem.findViewById<TextView>(R.id.title).text = getItem(position).title
                rowItem.findViewById<TextView>(R.id.message).text = getItem(position).message
                rowItem.findViewById<TextView>(R.id.time).text = getItem(position).nowData
            }
            cmp < 0 -> {
                rowItem =
                    LayoutInflater.from(context).inflate(R.layout.item_note, parent, false)

                rowItem.findViewById<TextView>(R.id.title).text = getItem(position).title
                rowItem.findViewById<TextView>(R.id.message).text = getItem(position).message
                rowItem.findViewById<TextView>(R.id.time).text = getItem(position).nowData
            }
            cmp == 0 -> {
                rowItem =
                    LayoutInflater.from(context).inflate(R.layout.item_note_today, parent, false)

                rowItem.findViewById<TextView>(R.id.title).text = getItem(position).title
                rowItem.findViewById<TextView>(R.id.message).text = getItem(position).message
                rowItem.findViewById<TextView>(R.id.time).text = getItem(position).nowData

            }
        }
        rowItem.setOnClickListener{

        }
        return rowItem
    }

}