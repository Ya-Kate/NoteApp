package com.example.androidprojectone

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class AdapterNote(val context: Context, val list: ArrayList<Note>) : BaseAdapter() {


    override fun getCount() = list.size

    override fun getItem(position: Int) = list[position]

    override fun getItemId(position: Int) = position.toLong()


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowItem: View = LayoutInflater.from(context).inflate(R.layout.item_note, parent, false)

        rowItem.findViewById<TextView>(R.id.title).text = getItem(position).title
        rowItem.findViewById<TextView>(R.id.message).text = getItem(position).message
        rowItem.findViewById<TextView>(R.id.time).text = getItem(position).nowData

        return rowItem
    }

}