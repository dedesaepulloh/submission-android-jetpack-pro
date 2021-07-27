@file:Suppress("DEPRECATED_ANNOTATION")

package com.dedesaepulloh.architecturecomponent.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieEntity(
    val id: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val vote_average: Double
) : Parcelable