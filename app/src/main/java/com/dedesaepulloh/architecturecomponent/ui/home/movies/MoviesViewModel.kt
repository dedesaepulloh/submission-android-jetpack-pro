package com.dedesaepulloh.architecturecomponent.ui.home.movies

import androidx.lifecycle.ViewModel
import com.dedesaepulloh.architecturecomponent.model.MovieEntity
import com.dedesaepulloh.architecturecomponent.utils.DataDummy

class MoviesViewModel : ViewModel() {
    fun getMovies(): List<MovieEntity> =
        DataDummy.generateDummyPopularMovies()
}