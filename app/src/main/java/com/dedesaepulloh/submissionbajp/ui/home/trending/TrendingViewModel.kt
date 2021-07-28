package com.dedesaepulloh.submissionbajp.ui.home.trending

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dedesaepulloh.submissionbajp.data.model.MovieEntity
import com.dedesaepulloh.submissionbajp.data.source.CatalogRepository

class TrendingViewModel(private val catalogRepository: CatalogRepository) : ViewModel() {
    fun getTrending(): LiveData<List<MovieEntity>> =
        catalogRepository.getTrending()
}