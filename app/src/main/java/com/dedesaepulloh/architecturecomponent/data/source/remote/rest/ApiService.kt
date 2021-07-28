package com.dedesaepulloh.architecturecomponent.data.source.remote.rest

import com.dedesaepulloh.architecturecomponent.BuildConfig
import com.dedesaepulloh.architecturecomponent.data.source.remote.response.ListResponse
import com.dedesaepulloh.architecturecomponent.data.source.remote.response.movie.MovieResponse
import com.dedesaepulloh.architecturecomponent.data.source.remote.response.tvshow.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    fun getMoviePopular(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Call<ListResponse<MovieResponse>>

    @GET("movie/{movie_id}")
    fun getDetailMovie(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Call<MovieResponse>

    @GET("tv/popular")
    fun getTvShowPopular(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Call<ListResponse<TvShowResponse>>

    @GET("tv/{tv_id}")
    fun getDetailTvShow(
        @Path("tv_id") tvShowId: Int,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Call<TvShowResponse>


}