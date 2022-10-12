package com.example.flixsterpeopleplus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

private const val TAG = "DetailActivity"

class DetailsActivity : AppCompatActivity() {
    private lateinit var personImage: ImageView
    private lateinit var movieImage: ImageView
    private lateinit var personName: TextView
    private lateinit var movieTitle: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        personImage = findViewById(R.id.personImage)
        movieImage = findViewById(R.id.movieImage)
        personName = findViewById(R.id.personName)
        movieTitle = findViewById(R.id.movieTitle)

       // val serialData = intent.getSerializableExtra()


    }
}