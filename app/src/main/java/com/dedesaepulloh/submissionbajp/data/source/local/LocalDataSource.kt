package com.dedesaepulloh.submissionbajp.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.dedesaepulloh.submissionbajp.data.source.local.entity.MovieEntity
import com.dedesaepulloh.submissionbajp.data.source.local.entity.TrendingEntity
import com.dedesaepulloh.submissionbajp.data.source.local.entity.TvShowEntity
import com.dedesaepulloh.submissionbajp.data.source.local.room.CatalogDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val mCatalogDao: CatalogDao) {

    fun getAllMovie(): DataSource.Factory<Int, MovieEntity> = mCatalogDao.getMoviePopular()

    fun getAllTvShow(): DataSource.Factory<Int, TvShowEntity> = mCatalogDao.getTvShowPopular()

    fun getAllTrending(): DataSource.Factory<Int, TrendingEntity> = mCatalogDao.getTrending()

    fun getMovieById(movieId: Int): LiveData<MovieEntity> = mCatalogDao.getMovieDetail(movieId)

    fun getTvShowById(tvShowId: Int): LiveData<TvShowEntity> = mCatalogDao.getTvShowDetail(tvShowId)

    fun getTrendingById(trendingId: Int): LiveData<TrendingEntity> =
        mCatalogDao.getTrendingDetail(trendingId)

    fun getMovieFavorites(): DataSource.Factory<Int, MovieEntity> = mCatalogDao.getFavoriteMovie()

    fun getTvShowFavorites(): DataSource.Factory<Int, TvShowEntity> =
        mCatalogDao.getFavoriteTvShow()

    fun getTrendingFavorites(): DataSource.Factory<Int, TrendingEntity> =
        mCatalogDao.getFavoriteTrending()

    fun insertMovies(movie: List<MovieEntity>) = mCatalogDao.insertMovie(movie)

    fun insertTvShows(tvShow: List<TvShowEntity>) = mCatalogDao.insertTvShow(tvShow)

    fun insertTrending(trending: List<TrendingEntity>) = mCatalogDao.insertTrending(trending)

    fun setFavoriteMovie(movie: MovieEntity, newState: Boolean) {
        movie.favorite = newState
        mCatalogDao.updateMovie(movie)
    }

    fun setFavoriteTvShow(tvShow: TvShowEntity, newState: Boolean) {
        tvShow.favorite = newState
        mCatalogDao.updateTvShow(tvShow)
    }

    fun setFavoriteTrending(trending: TrendingEntity, newState: Boolean) {
        trending.favorite = newState
        mCatalogDao.updateTrending(trending)
    }

}