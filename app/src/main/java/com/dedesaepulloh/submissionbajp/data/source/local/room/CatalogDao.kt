package com.dedesaepulloh.submissionbajp.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.dedesaepulloh.submissionbajp.data.source.local.entity.MovieEntity
import com.dedesaepulloh.submissionbajp.data.source.local.entity.TrendingEntity
import com.dedesaepulloh.submissionbajp.data.source.local.entity.TvShowEntity

@Dao
interface CatalogDao {

    @Query("SELECT * FROM tbl_movie")
    fun getMoviePopular(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tbl_tvshow")
    fun getTvShowPopular(): DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM tbl_trending")
    fun getTrending(): DataSource.Factory<Int, TrendingEntity>

    @Query("SELECT * FROM tbl_movie WHERE movieId = :movieId")
    fun getMovieDetail(movieId: Int): LiveData<MovieEntity>

    @Query("SELECT * FROM tbl_tvshow WHERE tvShowId = :tvShowId")
    fun getTvShowDetail(tvShowId: Int): LiveData<TvShowEntity>

    @Query("SELECT * FROM tbl_trending WHERE trendingId = :trendingId")
    fun getTrendingDetail(trendingId: Int): LiveData<TrendingEntity>

    @Query("SELECT * FROM tbl_movie WHERE favorite = 1")
    fun getFavoriteMovie(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tbl_tvshow WHERE favorite = 1")
    fun getFavoriteTvShow(): DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM tbl_trending WHERE favorite = 1")
    fun getFavoriteTrending(): DataSource.Factory<Int, TrendingEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShow(tvShow: List<TvShowEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTrending(trending: List<TrendingEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Update
    fun updateTvShow(tvShow: TvShowEntity)

    @Update
    fun updateTrending(trending: TrendingEntity)

}