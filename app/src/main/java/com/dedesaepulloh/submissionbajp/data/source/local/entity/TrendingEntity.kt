package com.dedesaepulloh.submissionbajp.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "tbl_trending")
data class TrendingEntity(

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "trendingId")
    val trendingId: Int,

    @ColumnInfo(name = "original_title")
    val original_title: String? = null,

    @ColumnInfo(name = "overview")
    val overview: String? = null,

    @ColumnInfo(name = "popularity")
    val popularity: Double? = null,

    @ColumnInfo(name = "poster_path")
    val poster_path: String? = null,

    @ColumnInfo(name = "release_date")
    val release_date: String? = null,

    @ColumnInfo(name = "vote_average")
    val vote_average: Double? = null,

    @ColumnInfo(name = "favorite")
    var favorite: Boolean = false

) : Parcelable