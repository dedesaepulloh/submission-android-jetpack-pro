package com.dedesaepulloh.submissionbajp.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dedesaepulloh.submissionbajp.data.source.CatalogRepository
import com.dedesaepulloh.submissionbajp.data.source.local.entity.MovieEntity
import com.dedesaepulloh.submissionbajp.data.source.local.entity.TrendingEntity
import com.dedesaepulloh.submissionbajp.data.source.local.entity.TvShowEntity

class FavoriteViewModel(private val catalogRepository: CatalogRepository) : ViewModel() {
    fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>> =
        catalogRepository.getFavoriteMovie()

    fun getFavoriteTvShow(): LiveData<PagedList<TvShowEntity>> =
        catalogRepository.getFavoriteTvShow()

    fun getFavoriteTrending(): LiveData<PagedList<TrendingEntity>> =
        catalogRepository.getFavoriteTrending()
}