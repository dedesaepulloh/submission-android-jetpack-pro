package com.dedesaepulloh.architecturecomponent.ui.home.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dedesaepulloh.architecturecomponent.data.model.MovieEntity
import com.dedesaepulloh.architecturecomponent.data.source.CatalogRepository

class TvShowViewModel(private val catalogRepository: CatalogRepository) : ViewModel() {
    fun getTvShow(): LiveData<List<MovieEntity>> =
        catalogRepository.getTvShowPopular()
}