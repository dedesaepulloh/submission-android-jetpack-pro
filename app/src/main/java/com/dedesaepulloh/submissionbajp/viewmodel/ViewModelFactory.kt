package com.dedesaepulloh.submissionbajp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dedesaepulloh.submissionbajp.data.source.CatalogRepository
import com.dedesaepulloh.submissionbajp.di.AppScope
import com.dedesaepulloh.submissionbajp.ui.detail.DetailViewModel
import com.dedesaepulloh.submissionbajp.ui.favorite.FavoriteViewModel
import com.dedesaepulloh.submissionbajp.ui.movies.MoviesViewModel
import com.dedesaepulloh.submissionbajp.ui.trending.TrendingViewModel
import com.dedesaepulloh.submissionbajp.ui.tvshow.TvShowViewModel
import javax.inject.Inject

@AppScope
class ViewModelFactory @Inject constructor(private val mCatalogRepository: CatalogRepository) :
    ViewModelProvider.NewInstanceFactory() {

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
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(mCatalogRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}