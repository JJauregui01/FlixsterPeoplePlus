package com.example.flixsterpeopleplus
import android.support.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class BaseResponse(
    @SerialName("results")
    val listOfPeople: List<SerialData>
)

@Keep
@Serializable
data class SerialData(
    @SerialName("name")
    val peopleName: String?,
    @SerialName("profile_path")
    val personPic: String?,
    @SerialName("known_for")
    val knownForList: List<KnowFor>

):java.io.Serializable

@Keep
@Serializable
data class KnowFor(
    @SerialName("original_title")
    val movieTitle: String? = null,
    @SerialName("overview")
    val movieDescription: String,
    @SerialName("poster_path")
    val movieImage: String?
):java.io.Serializable


