package com.dedesaepulloh.architecturecomponent.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dedesaepulloh.architecturecomponent.data.model.MovieEntity
import com.dedesaepulloh.architecturecomponent.data.source.remote.RemoteDataSource
import com.dedesaepulloh.architecturecomponent.data.source.remote.response.movie.MovieResponse
import com.dedesaepulloh.architecturecomponent.data.source.remote.response.tvshow.TvShowResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class CatalogRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    CatalogDataSource {

    companion object {
        private var instance: CatalogRepository? = null
        fun getInstance(remoteDataSource: RemoteDataSource): CatalogRepository =
            instance ?: synchronized(this) {
                instance ?: CatalogRepository(remoteDataSource).apply {
                    instance = this
                }
            }
    }

    override fun getMoviePopular(): LiveData<List<MovieEntity>> {
        val movieResult = MutableLiveData<List<MovieEntity>>()
        CoroutineScope(IO).launch {
            remoteDataSource.getMoviePopular(object : RemoteDataSource.LoadMoviePopularCallback {
                override fun onAllMovieReceived(movieResponse: List<MovieResponse?>) {
                    val movieList = ArrayList<MovieEntity>()
                    if (movieResponse.isNotEmpty()) {
                        for (response in movieResponse) {
                            if (response !== null) {
                                val movie = MovieEntity(
                                    response.id.toString(),
                                    response.original_title,
                                    response.overview,
                                    response.popularity,
                                    response.poster_path,
                                    response.release_date,
                                    response.vote_average
                                )
                                movieList.add(movie)
                            }
                        }
                        movieResult.postValue(movieList)
                    } else {
                        movieResult.postValue(movieList)
                    }

                }
            })
        }
        return movieResult
    }

    override fun getMovieDetail(movieId: Int): LiveData<MovieEntity> {
        val movieResult = MutableLiveData<MovieEntity>()
        CoroutineScope(IO).launch {
            remoteDataSource.getMovieDetail(
                movieId,
                object : RemoteDataSource.LoadDetailMovieCallback {
                    override fun onDetailMovieReceived(movieResponse: MovieResponse) {
                        val movie = MovieEntity(
                            movieResponse.id.toString(),
                            movieResponse.original_title,
                            movieResponse.overview,
                            movieResponse.popularity,
                            movieResponse.poster_path,
                            movieResponse.release_date,
                            movieResponse.vote_average
                        )
                        movieResult.postValue(movie)
                    }

                })
        }
        return movieResult
    }

    override fun getTvShowPopular(): LiveData<List<MovieEntity>> {
        val tvShowResult = MutableLiveData<List<MovieEntity>>()
        CoroutineScope(IO).launch {
            remoteDataSource.getTvShowPopular(object : RemoteDataSource.LoadTvShowPopularCallback {
                override fun onAllTvShowReceived(tvShowResponse: List<TvShowResponse?>) {
                    val tvShowList = ArrayList<MovieEntity>()
                    if (tvShowResponse.isNotEmpty()) {
                        for (response in tvShowResponse) {
                            if (response !== null) {
                                val tvShow = MovieEntity(
                                    response.id.toString(),
                                    response.original_name,
                                    response.overview,
                                    response.popularity,
                                    response.poster_path,
                                    response.first_air_date,
                                    response.vote_average
                                )
                                tvShowList.add(tvShow)
                            }
                        }
                        tvShowResult.postValue(tvShowList)
                    } else {
                        tvShowResult.postValue(tvShowList)
                    }
                }
            })
        }
        return tvShowResult
    }

    override fun getTvShowDetail(tvShowId: Int): LiveData<MovieEntity> {
        val tvShowResult = MutableLiveData<MovieEntity>()
        CoroutineScope(IO).launch {
            remoteDataSource.getTvShowDetail(
                tvShowId,
                object : RemoteDataSource.LoadDetailTvShowCallback {
                    override fun onDetailTvShowReceived(tvShowResponse: TvShowResponse) {
                        val movie = MovieEntity(
                            tvShowResponse.id.toString(),
                            tvShowResponse.original_name,
                            tvShowResponse.overview,
                            tvShowResponse.popularity,
                            tvShowResponse.poster_path,
                            tvShowResponse.first_air_date,
                            tvShowResponse.vote_average
                        )
                        tvShowResult.postValue(movie)
                    }

                })
        }
        return tvShowResult
    }

    override fun getTrending(): LiveData<List<MovieEntity>> {
        val movieResult = MutableLiveData<List<MovieEntity>>()
        CoroutineScope(IO).launch {
            remoteDataSource.getTrendingMovie(object : RemoteDataSource.LoadTrendingCallback {
                override fun onAllTrendingReceived(movieResponse: List<MovieResponse?>) {
                    val movieList = ArrayList<MovieEntity>()
                    if (movieResponse.isNotEmpty()) {
                        for (response in movieResponse) {
                            if (response !== null) {
                                val movie = MovieEntity(
                                    response.id.toString(),
                                    response.original_title,
                                    response.overview,
                                    response.popularity,
                                    response.poster_path,
                                    response.release_date,
                                    response.vote_average
                                )
                                movieList.add(movie)
                            }
                        }
                        movieResult.postValue(movieList)
                    } else {
                        movieResult.postValue(movieList)
                    }
                }
            })
        }
        return movieResult
    }
}