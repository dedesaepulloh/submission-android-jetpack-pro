package com.dedesaepulloh.submissionbajp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dedesaepulloh.submissionbajp.data.source.CatalogRepository
import com.dedesaepulloh.submissionbajp.di.Injection
import com.dedesaepulloh.submissionbajp.ui.detail.DetailViewModel
import com.dedesaepulloh.submissionbajp.ui.home.movies.MoviesViewModel
import com.dedesaepulloh.submissionbajp.ui.home.trending.TrendingViewModel
import com.dedesaepulloh.submissionbajp.ui.home.tvshow.TvShowViewModel

class ViewModelFactory private constructor(private val mCatalogRepository: CatalogRepository) :
    ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideCatalogRepository()).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(mCatalogRepository) as T
            }
            modelClass.isAssignableFrom(MoviesViewModel::class.java) -> {
                MoviesViewModel(mCatalogRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                TvShowViewModel(mCatalogRepository) as T
            }
            modelClass.isAssignableFrom(TrendingViewModel::class.java) -> {
                TrendingViewModel(mCatalogRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }

}