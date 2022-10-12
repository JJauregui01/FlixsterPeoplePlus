package com.example.flixsterpeopleplus

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide


class PeopleAdapter(private val context: Context, private val articles: List<SerialData>) :
    RecyclerView.Adapter<PeopleAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.main_page, parent, false)
        return ViewHolder(view)
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var personPic: ImageView = itemView.findViewById(R.id.personPic)
        var personTitle: TextView = itemView.findViewById(R.id.personTitle)
        var mItem: SerialData
    }
}