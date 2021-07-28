package com.dedesaepulloh.submissionbajp.ui.home.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dedesaepulloh.submissionbajp.data.model.MovieEntity
import com.dedesaepulloh.submissionbajp.data.source.CatalogRepository

class MoviesViewModel(private val catalogRepository: CatalogRepository) : ViewModel() {
    fun getMovies(): LiveData<List<MovieEntity>> =
        catalogRepository.getMoviePopular()
}