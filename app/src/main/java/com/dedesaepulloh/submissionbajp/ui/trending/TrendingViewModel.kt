package com.dedesaepulloh.submissionbajp.ui.home.trending

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dedesaepulloh.submissionbajp.data.source.CatalogRepository
import com.dedesaepulloh.submissionbajp.data.source.local.entity.MovieEntity
import com.dedesaepulloh.submissionbajp.data.source.local.entity.TrendingEntity
import com.dedesaepulloh.submissionbajp.vo.Resource

class TrendingViewModel(private val catalogRepository: CatalogRepository) : ViewModel() {
    fun getTrending(): LiveData<Resource<PagedList<TrendingEntity>>> =
        catalogRepository.getTrending()
}