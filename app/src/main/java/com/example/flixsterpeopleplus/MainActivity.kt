package com.example.flixsterpeopleplus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.RequestParams
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import com.google.gson.Gson
import com.google.gson.JsonIOException
import com.google.gson.reflect.TypeToken
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import okhttp3.Headers
import org.json.JSONException
import kotlin.math.log


fun createJson() = Json {
    isLenient = true
    ignoreUnknownKeys = true
    useAlternativeNames = false
}

private const val API_KEY = "a07e22bc18f5cb106bfe4cc1f83ad8ed"
class MainActivity : AppCompatActivity() {
    private lateinit var theRecyclerView: RecyclerView
    private val people = mutableListOf<SerialData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        theRecyclerView = findViewById(R.id.listOfItems)
        val theAdapter = PeopleAdapter(this, people)
        theRecyclerView.adapter = theAdapter
        theRecyclerView.layoutManager = GridLayoutManager(this, 2)

        val client = AsyncHttpClient()
        val params = RequestParams()
        params["api_key"] = API_KEY

        client[
                "https://api.themoviedb.org/3/person/popular",
                params,
                object: JsonHttpResponseHandler() {
                    override fun onFailure(
                        statusCode: Int,
                        headers: Headers?,
                        response: String,
                        throwable: Throwable?
                    ) {
                        throwable?.message?.let {
                            Log.e("PeopleFragment", response)
                        }
                    }

                    override fun onSuccess(statusCode: Int, headers: Headers?, json: JSON) {

                        try {
                            val parJson = createJson().decodeFromString(
                                BaseResponse.serializer(),
                                json.jsonObject.toString()
                            )
                            parJson.listOfPeople?.let { list ->
                                people.addAll(list)
                                 theAdapter.notifyItemRangeInserted(0, people.size)

                            }
                        }
                        catch (e: JSONException){
                            Log.e("Main", "Error")
                        }
                    }
                }
        ]
    }
}