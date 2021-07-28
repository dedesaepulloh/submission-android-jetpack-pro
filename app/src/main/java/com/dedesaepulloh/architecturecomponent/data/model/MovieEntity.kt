@file:Suppress("DEPRECATED_ANNOTATION")

package com.dedesaepulloh.architecturecomponent.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieEntity(
    val id: String? = null,
    val original_title: String? = null,
    val overview: String? = null,
    val popularity: Double? = null,
    val poster_path: String? = null,
    val release_date: String? = null,
    val vote_average: Double? = null
) : Parcelable