package com.dedesaepulloh.submissionbajp.data.source.remote.response.movie

import com.google.gson.annotations.SerializedName

data class MovieResponse(

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("original_title")
    val original_title: String? = null,

    @SerializedName("overview")
    val overview: String? = null,

    @SerializedName("popularity")
    val popularity: Double? = null,

    @SerializedName("poster_path")
    val poster_path: String? = null,

    @SerializedName("release_date")
    val release_date: String? = null,

    @SerializedName("vote_average")
    val vote_average: Double? = null

)