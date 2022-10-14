package com.example.flixsterpeopleplus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

private const val TAG = "DetailActivity"

class DetailsActivity : AppCompatActivity() {
    private lateinit var personImage: ImageView
    private lateinit var movieImage: ImageView
    private lateinit var personName: TextView
    private lateinit var movieTitle: TextView
    private lateinit var movieDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        personImage = findViewById(R.id.personImage)
        movieImage = findViewById(R.id.movieImage)
        personName = findViewById(R.id.personName)
        movieTitle = findViewById(R.id.movieTitle)
        movieDescription = findViewById(R.id.movieDescription)

        val serialData = intent.getSerializableExtra("key") as SerialData
        var movieURLink = "https://image.tmdb.org/t/p/w500/" + serialData.knownForList?.get(0)?.movieImage
        personName.text = serialData.peopleName
        Glide.with(this).load(movieURLink).into(movieImage)
        var personURL = "https://image.tmdb.org/t/p/w500/" + serialData.personPic
        Glide.with(this).load(personURL).into(personImage)
        movieDescription.text = serialData.knownForList?.get(0)?.movieDescription

        movieTitle.text = serialData.knownForList?.get(0)?.movieTitle





    }
}