package com.dedesaepulloh.architecturecomponent.data.source

import androidx.lifecycle.LiveData
import com.dedesaepulloh.architecturecomponent.data.model.MovieEntity

interface CatalogDataSource {
    fun getMoviePopular(): LiveData<List<MovieEntity>>
    fun getMovieDetail(movieId: Int): LiveData<MovieEntity>

    fun getTvShowPopular(): LiveData<List<MovieEntity>>
    fun getTvShowDetail(tvShowId: Int): LiveData<MovieEntity>

    fun getTrending(): LiveData<List<MovieEntity>>
}