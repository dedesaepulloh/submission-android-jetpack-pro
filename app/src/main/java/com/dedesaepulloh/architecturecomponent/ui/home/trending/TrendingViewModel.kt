package com.dedesaepulloh.architecturecomponent.ui.home.trending

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dedesaepulloh.architecturecomponent.data.model.MovieEntity
import com.dedesaepulloh.architecturecomponent.data.source.CatalogRepository

class TrendingViewModel(private val catalogRepository: CatalogRepository) : ViewModel() {
    fun getTrending(): LiveData<List<MovieEntity>> =
        catalogRepository.getTrending()
}