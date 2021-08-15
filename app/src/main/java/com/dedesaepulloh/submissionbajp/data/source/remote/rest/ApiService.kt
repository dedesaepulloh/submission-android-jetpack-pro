package com.dedesaepulloh.submissionbajp.data.source.remote.rest

import com.dedesaepulloh.submissionbajp.BuildConfig
import com.dedesaepulloh.submissionbajp.data.source.remote.response.ListResponse
import com.dedesaepulloh.submissionbajp.data.source.remote.response.movie.MovieResponse
import com.dedesaepulloh.submissionbajp.data.source.remote.response.trending.TrendingResponse
import com.dedesaepulloh.submissionbajp.data.source.remote.response.tvshow.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    fun getMoviePopular(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Call<ListResponse<MovieResponse>>

    @GET("tv/popular")
    fun getTvShowPopular(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Call<ListResponse<TvShowResponse>>

    @GET("trending/movie/day?")
    fun getMovieTrending(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Call<ListResponse<TrendingResponse>>

}