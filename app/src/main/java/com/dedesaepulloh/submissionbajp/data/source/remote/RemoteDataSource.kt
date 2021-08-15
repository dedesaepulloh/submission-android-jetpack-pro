package com.dedesaepulloh.submissionbajp.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dedesaepulloh.submissionbajp.data.source.remote.response.ListResponse
import com.dedesaepulloh.submissionbajp.data.source.remote.response.movie.MovieResponse
import com.dedesaepulloh.submissionbajp.data.source.remote.response.trending.TrendingResponse
import com.dedesaepulloh.submissionbajp.data.source.remote.response.tvshow.TvShowResponse
import com.dedesaepulloh.submissionbajp.data.source.remote.response.vo.ApiResponse
import com.dedesaepulloh.submissionbajp.data.source.remote.rest.ApiConfig
import com.dedesaepulloh.submissionbajp.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor() {

    fun getMoviePopular(): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        ApiConfig.getApiService().getMoviePopular()
            .enqueue(object : Callback<ListResponse<MovieResponse>> {
                override fun onResponse(
                    call: Call<ListResponse<MovieResponse>>,
                    response: Response<ListResponse<MovieResponse>>
                ) {
                    if (response.isSuccessful) {
                        resultMovie.postValue(ApiResponse.success(response.body()?.results as List<MovieResponse>))
                    }
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<ListResponse<MovieResponse>>, t: Throwable) {
                    Log.e("Failure", "${t.message}")
                    resultMovie.postValue(ApiResponse.error(t.message.toString(), mutableListOf()))
                    EspressoIdlingResource.decrement()
                }
            })
        return resultMovie
    }

    fun getTvShowPopular(): LiveData<ApiResponse<List<TvShowResponse>>> {
        EspressoIdlingResource.increment()
        val resultTvShow = MutableLiveData<ApiResponse<List<TvShowResponse>>>()
        ApiConfig.getApiService().getTvShowPopular()
            .enqueue(object : Callback<ListResponse<TvShowResponse>> {
                override fun onResponse(
                    call: Call<ListResponse<TvShowResponse>>,
                    response: Response<ListResponse<TvShowResponse>>
                ) {
                    if (response.isSuccessful) {
                        resultTvShow.postValue(ApiResponse.success(response.body()?.results as List<TvShowResponse>))
                    }
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<ListResponse<TvShowResponse>>, t: Throwable) {
                    Log.e("Failure", "${t.message}")
                    resultTvShow.postValue(ApiResponse.error(t.message.toString(), mutableListOf()))
                    EspressoIdlingResource.decrement()
                }
            })
        return resultTvShow
    }

    fun getTrendingMovie(): LiveData<ApiResponse<List<TrendingResponse>>> {
        EspressoIdlingResource.increment()
        val resultTrending = MutableLiveData<ApiResponse<List<TrendingResponse>>>()
        ApiConfig.getApiService().getMovieTrending()
            .enqueue(object : Callback<ListResponse<TrendingResponse>> {
                override fun onResponse(
                    call: Call<ListResponse<TrendingResponse>>,
                    response: Response<ListResponse<TrendingResponse>>
                ) {
                    if (response.isSuccessful) {
                        resultTrending.postValue(ApiResponse.success(response.body()?.results as List<TrendingResponse>))
                    }
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<ListResponse<TrendingResponse>>, t: Throwable) {
                    Log.e("Failure", "${t.message}")
                    resultTrending.postValue(
                        ApiResponse.error(
                            t.message.toString(),
                            mutableListOf()
                        )
                    )
                    EspressoIdlingResource.decrement()
                }
            })
        return resultTrending
    }
}
