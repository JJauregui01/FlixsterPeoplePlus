package com.example.flixsterpeopleplus

import android.content.Context
import android.content.Intent
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


class PeopleAdapter(private val context: Context, private val people: List<SerialData>) :
    RecyclerView.Adapter<PeopleAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.main_page, parent, false)
        return ViewHolder(view)
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var personPic: ImageView = itemView.findViewById(R.id.personPic)
        var personTitle: TextView = itemView.findViewById(R.id.personTitle)
        var mItem: SerialData? = null
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(p0: View?) {
            val person = people[absoluteAdapterPosition]
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("key", person)
            context.startActivity(intent)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = people[position]
        holder.mItem = person
        holder.personTitle.text = person.peopleName

       val movieURL = "https://image.tmdb.org/t/p/w500/" + person.personPic
        Glide.with(holder.itemView).load(movieURL).into(holder.personPic)

    }

    override fun getItemCount(): Int {
        return people.size
    }


}