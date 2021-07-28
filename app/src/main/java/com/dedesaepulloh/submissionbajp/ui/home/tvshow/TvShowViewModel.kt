package com.dedesaepulloh.submissionbajp.ui.home.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dedesaepulloh.submissionbajp.data.model.MovieEntity
import com.dedesaepulloh.submissionbajp.data.source.CatalogRepository

class TvShowViewModel(private val catalogRepository: CatalogRepository) : ViewModel() {
    fun getTvShow(): LiveData<List<MovieEntity>> =
        catalogRepository.getTvShowPopular()
}