package com.dedesaepulloh.architecturecomponent.data.source.remote

import android.util.Log
import com.dedesaepulloh.architecturecomponent.data.source.remote.response.ListResponse
import com.dedesaepulloh.architecturecomponent.data.source.remote.response.movie.MovieResponse
import com.dedesaepulloh.architecturecomponent.data.source.remote.response.tvshow.TvShowResponse
import com.dedesaepulloh.architecturecomponent.data.source.remote.rest.ApiConfig
import com.dedesaepulloh.architecturecomponent.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Response

class RemoteDataSource private constructor() {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource().apply { instance = this }
            }
    }

    fun getMoviePopular(callback: LoadMoviePopularCallback) {
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getMoviePopular()
            .enqueue(object : retrofit2.Callback<ListResponse<MovieResponse>> {
                override fun onResponse(
                    call: Call<ListResponse<MovieResponse>>,
                    response: Response<ListResponse<MovieResponse>>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.results?.let { callback.onAllMovieReceived(it) }
                    }
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<ListResponse<MovieResponse>>, t: Throwable) {
                    Log.e("Failure", "${t.message}")
                    callback.onAllMovieReceived(emptyList())
                    EspressoIdlingResource.decrement()
                }
            })
    }

    fun getMovieDetail(movieId: Int, callback: LoadDetailMovieCallback) {
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getDetailMovie(movieId)
            .enqueue(object : retrofit2.Callback<MovieResponse> {
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let { callback.onDetailMovieReceived(it) }
                    }
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    Log.e("Failure", "${t.message}")
                    EspressoIdlingResource.decrement()
                }
            })
    }

    fun getTvShowPopular(callback: LoadTvShowPopularCallback) {
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getTvShowPopular()
            .enqueue(object : retrofit2.Callback<ListResponse<TvShowResponse>> {
                override fun onResponse(
                    call: Call<ListResponse<TvShowResponse>>,
                    response: Response<ListResponse<TvShowResponse>>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.results?.let { callback.onAllTvShowReceived(it) }
                    }
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<ListResponse<TvShowResponse>>, t: Throwable) {
                    Log.e("Failure", "${t.message}")
                    callback.onAllTvShowReceived(emptyList())
                    EspressoIdlingResource.decrement()
                }
            })
    }

    fun getTvShowDetail(tvShowId: Int, callback: LoadDetailTvShowCallback) {
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getDetailTvShow(tvShowId)
            .enqueue(object : retrofit2.Callback<TvShowResponse> {
                override fun onResponse(
                    call: Call<TvShowResponse>,
                    response: Response<TvShowResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let { callback.onDetailTvShowReceived(it) }
                    }
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                    Log.e("Failure", "${t.message}")
                    EspressoIdlingResource.decrement()
                }
            })
    }

    fun getTrendingMovie(callback: LoadTrendingCallback) {
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getMovieTrending()
            .enqueue(object : retrofit2.Callback<ListResponse<MovieResponse>> {
                override fun onResponse(
                    call: Call<ListResponse<MovieResponse>>,
                    response: Response<ListResponse<MovieResponse>>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.results?.let { callback.onAllTrendingReceived(it) }
                    }
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<ListResponse<MovieResponse>>, t: Throwable) {
                    Log.e("Failure", "${t.message}")
                    callback.onAllTrendingReceived(emptyList())
                    EspressoIdlingResource.decrement()
                }
            })
    }

    interface LoadMoviePopularCallback {
        fun onAllMovieReceived(movieResponse: List<MovieResponse?>)
    }

    interface LoadDetailMovieCallback {
        fun onDetailMovieReceived(movieResponse: MovieResponse)
    }

    interface LoadTvShowPopularCallback {
        fun onAllTvShowReceived(tvShowResponse: List<TvShowResponse?>)
    }

    interface LoadDetailTvShowCallback {
        fun onDetailTvShowReceived(tvShowResponse: TvShowResponse)
    }

    interface LoadTrendingCallback {
        fun onAllTrendingReceived(movieResponse: List<MovieResponse?>)
    }

}
