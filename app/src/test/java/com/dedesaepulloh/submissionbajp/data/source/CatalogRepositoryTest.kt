package com.dedesaepulloh.submissionbajp.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.dedesaepulloh.submissionbajp.TestExecutor
import com.dedesaepulloh.submissionbajp.data.source.local.LocalDataSource
import com.dedesaepulloh.submissionbajp.data.source.local.entity.MovieEntity
import com.dedesaepulloh.submissionbajp.data.source.local.entity.TrendingEntity
import com.dedesaepulloh.submissionbajp.data.source.local.entity.TvShowEntity
import com.dedesaepulloh.submissionbajp.data.source.local.room.CatalogDao
import com.dedesaepulloh.submissionbajp.data.source.remote.RemoteDataSource
import com.dedesaepulloh.submissionbajp.utils.AppExecutors
import com.dedesaepulloh.submissionbajp.utils.DataDummy
import com.dedesaepulloh.submissionbajp.vo.Resource
import com.nhaarman.mockitokotlin2.doNothing
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class CatalogRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val catalogDao = mock(CatalogDao::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val catalogRepository = FakeCatalogRepository(remote, local, appExecutors)

    private val movieResponse = DataDummy.generateDummyMovieResponse()
    private val movie = DataDummy.generateDummyPopularMovies()[0]

    private val tvShowResponse = DataDummy.generateDummyTvShowResponse()
    private val tvShow = DataDummy.generateDummyTvShow()[0]

    private val trendingResponse = DataDummy.generateDummyTrendingResponse()
    private val trending = DataDummy.generateDummyTrending()[0]

    @Test
    fun getMoviePopular() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovie()).thenReturn(dataSourceFactory)
        catalogRepository.getMoviePopular()

        val movieEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyPopularMovies()))
        verify(local).getAllMovie()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getMovieDetail() {
        val dummyMovie = MutableLiveData<MovieEntity>()
        dummyMovie.value = movie
        `when`(movie.movieId.let { local.getMovieById(it) }).thenReturn(dummyMovie)

        val data =
            LiveDataTestUtil.getValue(catalogRepository.getMovieDetail(movie.movieId))
        movie.movieId.let { verify(local).getMovieById(it) }

        assertNotNull(data)
        assertEquals(movie.movieId, data.movieId)
        assertEquals(movie.original_title, data.original_title)
        assertEquals(movie.overview, data.overview)
        assertEquals(movie.popularity, data.popularity)
        assertEquals(movie.poster_path, data.poster_path)
        assertEquals(movie.release_date, data.release_date)
        assertEquals(movie.vote_average, data.vote_average)
    }

    @Test
    fun getTvShowPopular() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getAllTvShow()).thenReturn(dataSourceFactory)
        catalogRepository.getTvShowPopular()

        val tvShowEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShow()))
        verify(local).getAllTvShow()
        assertNotNull(tvShowEntities.data)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getTvShowDetail() {
        val dummyTvShow = MutableLiveData<TvShowEntity>()
        dummyTvShow.value = tvShow
        `when`(tvShow.tvShowId.let { local.getTvShowById(it) })
            .thenReturn(dummyTvShow)

        val data =
            LiveDataTestUtil.getValue(catalogRepository.getTvShowDetail(tvShow.tvShowId))
        tvShow.tvShowId.let { verify(local).getTvShowById(it) }

        assertNotNull(data)
        assertEquals(tvShow.tvShowId, data.tvShowId)
        assertEquals(tvShow.original_name, data.original_name)
        assertEquals(tvShow.overview, data.overview)
        assertEquals(tvShow.popularity, data.popularity)
        assertEquals(tvShow.poster_path, data.poster_path)
        assertEquals(tvShow.first_air_date, data.first_air_date)
        assertEquals(tvShow.vote_average, data.vote_average)
    }

    @Test
    fun getTrending() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TrendingEntity>
        `when`(local.getAllTrending()).thenReturn(dataSourceFactory)
        catalogRepository.getTrending()

        val trendingEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTrending()))
        verify(local).getAllTrending()
        assertNotNull(trendingEntities.data)
        assertEquals(trendingResponse.size.toLong(), trendingEntities.data?.size?.toLong())
    }

    @Test
    fun getTrendingDetail() {
        val dummyTrending = MutableLiveData<TrendingEntity>()
        dummyTrending.value = trending
        `when`(trending.trendingId.let { local.getTrendingById(it) })
            .thenReturn(dummyTrending)

        val data =
            LiveDataTestUtil.getValue(catalogRepository.getTrendingDetail(trending.trendingId))
        trending.trendingId.let { verify(local).getTrendingById(it) }

        assertNotNull(data)
        assertEquals(trending.trendingId, data.trendingId)
        assertEquals(trending.original_title, data.original_title)
        assertEquals(trending.overview, data.overview)
        assertEquals(trending.popularity, data.popularity)
        assertEquals(trending.poster_path, data.poster_path)
        assertEquals(trending.release_date, data.release_date)
        assertEquals(trending.vote_average, data.vote_average)
    }

    @Test
    fun getFavoriteMovie() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getMovieFavorites()).thenReturn(dataSourceFactory)
        catalogRepository.getFavoriteMovie()

        val movieEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyPopularMovies()))
        verify(local).getMovieFavorites()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getFavoriteTvShow() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getTvShowFavorites()).thenReturn(dataSourceFactory)
        catalogRepository.getFavoriteTvShow()

        val tvShowEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShow()))
        verify(local).getTvShowFavorites()
        assertNotNull(tvShowEntities.data)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getFavoriteTrending() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TrendingEntity>
        `when`(local.getTrendingFavorites()).thenReturn(dataSourceFactory)
        catalogRepository.getFavoriteTrending()

        val trendingEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTrending()))
        verify(local).getTrendingFavorites()
        assertNotNull(trendingEntities.data)
        assertEquals(trendingResponse.size.toLong(), trendingEntities.data?.size?.toLong())
    }

    @Test
    fun setFavoriteMovie() {
        val localDataSource = LocalDataSource(catalogDao)
        val expectedMovie = movie.copy(favorite = true)
        val testExecutors = AppExecutors(TestExecutor(), TestExecutor(), TestExecutor())

        `when`(appExecutors.diskIO()).thenReturn(testExecutors.diskIO())

        doNothing().`when`(local).setFavoriteMovie(movie, true)
        catalogRepository.setFavoriteMovie(movie, true)
        verify(local).setFavoriteMovie(movie, true)

        doNothing().`when`(catalogDao).updateMovie(expectedMovie)
        localDataSource.setFavoriteMovie(movie, true)
        verify(catalogDao, times(1)).updateMovie(expectedMovie)
    }

    @Test
    fun setFavoriteTvShow() {
        val localDataSource = LocalDataSource(catalogDao)
        val expectedTvShow = tvShow.copy(favorite = true)
        val testExecutors = AppExecutors(TestExecutor(), TestExecutor(), TestExecutor())

        `when`(appExecutors.diskIO()).thenReturn(testExecutors.diskIO())

        doNothing().`when`(local).setFavoriteTvShow(tvShow, true)
        catalogRepository.setFavoriteTvShow(tvShow, true)
        verify(local).setFavoriteTvShow(tvShow, true)

        doNothing().`when`(catalogDao).updateTvShow(expectedTvShow)
        localDataSource.setFavoriteTvShow(tvShow, true)
        verify(catalogDao, times(1)).updateTvShow(expectedTvShow)
    }

    @Test
    fun setFavoriteTrending() {
        val localDataSource = LocalDataSource(catalogDao)
        val expectedTrending = trending.copy(favorite = true)
        val testExecutors = AppExecutors(TestExecutor(), TestExecutor(), TestExecutor())

        `when`(appExecutors.diskIO()).thenReturn(testExecutors.diskIO())

        doNothing().`when`(local).setFavoriteTrending(trending, true)
        catalogRepository.setFavoriteTrending(trending, true)
        verify(local).setFavoriteTrending(trending, true)

        doNothing().`when`(catalogDao).updateTrending(expectedTrending)
        localDataSource.setFavoriteTrending(trending, true)
        verify(catalogDao, times(1)).updateTrending(expectedTrending)
    }

}