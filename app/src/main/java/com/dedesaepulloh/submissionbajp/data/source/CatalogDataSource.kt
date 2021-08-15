package com.dedesaepulloh.submissionbajp.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.dedesaepulloh.submissionbajp.data.source.local.entity.MovieEntity
import com.dedesaepulloh.submissionbajp.data.source.local.entity.TrendingEntity
import com.dedesaepulloh.submissionbajp.data.source.local.entity.TvShowEntity
import com.dedesaepulloh.submissionbajp.vo.Resource

interface CatalogDataSource {

    fun getMoviePopular(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getTvShowPopular(): LiveData<Resource<PagedList<TvShowEntity>>>

    fun getTrending(): LiveData<Resource<PagedList<TrendingEntity>>>

    fun getMovieDetail(movieId: Int): LiveData<MovieEntity>

    fun getTvShowDetail(tvShowId: Int): LiveData<TvShowEntity>

    fun getTrendingDetail(trendingId: Int): LiveData<TrendingEntity>

    fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>>

    fun getFavoriteTvShow(): LiveData<PagedList<TvShowEntity>>

    fun getFavoriteTrending(): LiveData<PagedList<TrendingEntity>>

    fun setFavoriteMovie(movie: MovieEntity, state: Boolean)

    fun setFavoriteTvShow(tvShow: TvShowEntity, state: Boolean)

    fun setFavoriteTrending(trending: TrendingEntity, state: Boolean)

}