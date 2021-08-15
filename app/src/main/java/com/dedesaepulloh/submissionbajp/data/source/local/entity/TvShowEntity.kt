package com.dedesaepulloh.submissionbajp.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "tbl_tvshow")
data class TvShowEntity(

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tvShowId")
    val tvShowId: Int,

    @ColumnInfo(name = "original_name")
    val original_name: String? = null,

    @ColumnInfo(name = "overview")
    val overview: String? = null,

    @ColumnInfo(name = "popularity")
    val popularity: Double? = null,

    @ColumnInfo(name = "poster_path")
    val poster_path: String? = null,

    @ColumnInfo(name = "first_air_date")
    val first_air_date: String? = null,

    @ColumnInfo(name = "vote_average")
    val vote_average: Double? = null,

    @ColumnInfo(name = "favorite")
    var favorite: Boolean = false

) : Parcelable