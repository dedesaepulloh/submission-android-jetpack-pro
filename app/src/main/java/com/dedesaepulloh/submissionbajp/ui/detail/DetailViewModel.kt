package com.dedesaepulloh.submissionbajp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dedesaepulloh.submissionbajp.data.model.MovieEntity
import com.dedesaepulloh.submissionbajp.data.source.CatalogRepository

class DetailViewModel(private val catalogRepository: CatalogRepository) : ViewModel() {

    fun getMoviesById(movieId: Int): LiveData<MovieEntity> =
        catalogRepository.getMovieDetail(movieId)

    fun getTvShowById(tvShowId: Int): LiveData<MovieEntity> =
        catalogRepository.getTvShowDetail(tvShowId)
}