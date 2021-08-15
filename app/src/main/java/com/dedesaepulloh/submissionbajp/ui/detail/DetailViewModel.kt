package com.dedesaepulloh.submissionbajp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dedesaepulloh.submissionbajp.data.source.CatalogRepository
import com.dedesaepulloh.submissionbajp.data.source.local.entity.MovieEntity
import com.dedesaepulloh.submissionbajp.data.source.local.entity.TrendingEntity
import com.dedesaepulloh.submissionbajp.data.source.local.entity.TvShowEntity

class DetailViewModel(private val catalogRepository: CatalogRepository) : ViewModel() {

    fun getMoviesById(movieId: Int): LiveData<MovieEntity> =
        catalogRepository.getMovieDetail(movieId)

    fun getTvShowById(tvShowId: Int): LiveData<TvShowEntity> =
        catalogRepository.getTvShowDetail(tvShowId)

    fun getTrendingById(trendingId: Int): LiveData<TrendingEntity> =
        catalogRepository.getTrendingDetail(trendingId)

    fun setFavoriteMovie(movie: MovieEntity) {
        val newState = !movie.favorite
        catalogRepository.setFavoriteMovie(movie, newState)
    }

    fun setFavoriteTvShow(tvShow: TvShowEntity) {
        val newState = !tvShow.favorite
        catalogRepository.setFavoriteTvShow(tvShow, newState)
    }

    fun setFavoriteTrending(trending: TrendingEntity) {
        val newState = !trending.favorite
        catalogRepository.setFavoriteTrending(trending, newState)
    }

}