package com.dedesaepulloh.architecturecomponent.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dedesaepulloh.architecturecomponent.data.source.CatalogRepository
import com.dedesaepulloh.architecturecomponent.di.Injection
import com.dedesaepulloh.architecturecomponent.ui.detail.DetailViewModel
import com.dedesaepulloh.architecturecomponent.ui.home.movies.MoviesViewModel
import com.dedesaepulloh.architecturecomponent.ui.home.trending.TrendingViewModel
import com.dedesaepulloh.architecturecomponent.ui.home.tvshow.TvShowViewModel

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