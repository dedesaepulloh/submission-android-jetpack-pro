package com.dedesaepulloh.submissionbajp.data.source.remote.response.tvshow

import com.google.gson.annotations.SerializedName

data class TvShowResponse(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("original_name")
    val original_name: String? = null,
    @SerializedName("overview")
    val overview: String? = null,
    @SerializedName("popularity")
    val popularity: Double? = null,
    @SerializedName("poster_path")
    val poster_path: String? = null,
    @SerializedName("first_air_date")
    val first_air_date: String? = null,
    @SerializedName("vote_average")
    val vote_average: Double? = null
)