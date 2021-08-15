package com.dedesaepulloh.submissionbajp.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.dedesaepulloh.submissionbajp.data.source.local.LocalDataSource
import com.dedesaepulloh.submissionbajp.data.source.local.entity.MovieEntity
import com.dedesaepulloh.submissionbajp.data.source.local.entity.TrendingEntity
import com.dedesaepulloh.submissionbajp.data.source.local.entity.TvShowEntity
import com.dedesaepulloh.submissionbajp.data.source.remote.RemoteDataSource
import com.dedesaepulloh.submissionbajp.data.source.remote.response.movie.MovieResponse
import com.dedesaepulloh.submissionbajp.data.source.remote.response.trending.TrendingResponse
import com.dedesaepulloh.submissionbajp.data.source.remote.response.tvshow.TvShowResponse
import com.dedesaepulloh.submissionbajp.data.source.remote.response.vo.ApiResponse
import com.dedesaepulloh.submissionbajp.utils.AppExecutors
import com.dedesaepulloh.submissionbajp.vo.Resource

class FakeCatalogRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) :
    CatalogDataSource {

    override fun getMoviePopular(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object :
            NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(
                    localDataSource.getAllMovie(),
                    config
                ).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getMoviePopular()

            public override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data) {
                    val movie = response.id?.let {
                        MovieEntity(
                            it,
                            response.original_title,
                            response.overview,
                            response.popularity,
                            response.poster_path,
                            response.release_date,
                            response.vote_average
                        )
                    }
                    if (movie != null) {
                        movieList.add(movie)
                    }
                    localDataSource.insertMovies(movieList)
                }
            }
        }.asLiveData()
    }

    override fun getMovieDetail(movieId: Int): LiveData<MovieEntity> =
        localDataSource.getMovieById(movieId)

    override fun getTvShowPopular(): LiveData<Resource<PagedList<TvShowEntity>>> {
        return object :
            NetworkBoundResource<PagedList<TvShowEntity>, List<TvShowResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<TvShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(
                    localDataSource.getAllTvShow(),
                    config
                ).build()
            }

            override fun shouldFetch(data: PagedList<TvShowEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<TvShowResponse>>> =
                remoteDataSource.getTvShowPopular()

            public override fun saveCallResult(data: List<TvShowResponse>) {
                val tvShowList = ArrayList<TvShowEntity>()
                for (response in data) {
                    val tvShow = response.id?.let {
                        TvShowEntity(
                            it,
                            response.original_name,
                            response.overview,
                            response.popularity,
                            response.poster_path,
                            response.first_air_date,
                            response.vote_average
                        )
                    }
                    if (tvShow != null) {
                        tvShowList.add(tvShow)
                    }
                    localDataSource.insertTvShows(tvShowList)
                }
            }
        }.asLiveData()
    }

    override fun getTvShowDetail(tvShowId: Int): LiveData<TvShowEntity> =
        localDataSource.getTvShowById(tvShowId)

    override fun getTrendingDetail(trendingId: Int): LiveData<TrendingEntity> =
        localDataSource.getTrendingById(trendingId)

    override fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getMovieFavorites(), config).build()
    }

    override fun getFavoriteTvShow(): LiveData<PagedList<TvShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getTvShowFavorites(), config).build()
    }

    override fun getFavoriteTrending(): LiveData<PagedList<TrendingEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getTrendingFavorites(), config).build()
    }

    override fun setFavoriteMovie(movie: MovieEntity, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setFavoriteMovie(movie, state) }
    }

    override fun setFavoriteTvShow(tvShow: TvShowEntity, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setFavoriteTvShow(tvShow, state) }
    }

    override fun setFavoriteTrending(trending: TrendingEntity, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setFavoriteTrending(trending, state) }
    }

    override fun getTrending(): LiveData<Resource<PagedList<TrendingEntity>>> {
        return object :
            NetworkBoundResource<PagedList<TrendingEntity>, List<TrendingResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<TrendingEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(
                    localDataSource.getAllTrending(),
                    config
                ).build()
            }

            override fun shouldFetch(data: PagedList<TrendingEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<TrendingResponse>>> =
                remoteDataSource.getTrendingMovie()

            public override fun saveCallResult(data: List<TrendingResponse>) {
                val trendingList = ArrayList<TrendingEntity>()
                for (response in data) {
                    val trending = response.id?.let {
                        TrendingEntity(
                            it,
                            response.original_title,
                            response.overview,
                            response.popularity,
                            response.poster_path,
                            response.release_date,
                            response.vote_average
                        )
                    }
                    if (trending != null) {
                        trendingList.add(trending)
                    }
                    localDataSource.insertTrending(trendingList)
                }
            }
        }.asLiveData()
    }
}