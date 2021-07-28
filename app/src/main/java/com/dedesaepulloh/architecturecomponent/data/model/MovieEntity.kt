package com.dedesaepulloh.architecturecomponent.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class MovieEntity(
    val id: String? = null,
    val original_title: String? = null,
    val overview: String? = null,
    val popularity: Double? = null,
    val poster_path: String? = null,
    val release_date: String? = null,
    val vote_average: Double? = null
) : Parcelable