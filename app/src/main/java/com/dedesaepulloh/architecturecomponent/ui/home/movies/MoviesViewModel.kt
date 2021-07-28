package com.dedesaepulloh.architecturecomponent.ui.home.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dedesaepulloh.architecturecomponent.data.model.MovieEntity
import com.dedesaepulloh.architecturecomponent.data.source.CatalogRepository

class MoviesViewModel(private val catalogRepository: CatalogRepository) : ViewModel() {
    fun getMovies(): LiveData<List<MovieEntity>> =
        catalogRepository.getMoviePopular()
}