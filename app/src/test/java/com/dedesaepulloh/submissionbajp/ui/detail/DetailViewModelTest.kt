package com.dedesaepulloh.submissionbajp.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dedesaepulloh.submissionbajp.data.source.CatalogRepository
import com.dedesaepulloh.submissionbajp.data.source.local.entity.MovieEntity
import com.dedesaepulloh.submissionbajp.data.source.local.entity.TrendingEntity
import com.dedesaepulloh.submissionbajp.data.source.local.entity.TvShowEntity
import com.dedesaepulloh.submissionbajp.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovies = DataDummy.generateDummyPopularMovies()[0]
    private val dummyTvShow = DataDummy.generateDummyTvShow()[0]
    private val dummyTrending = DataDummy.generateDummyTrending()[0]
    private val movieId = dummyMovies.movieId
    private val tvShowId = dummyTvShow.tvShowId
    private val trendingId = dummyTrending.trendingId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogRepository: CatalogRepository

    @Mock
    private lateinit var observerMovie: Observer<MovieEntity>

    @Mock
    private lateinit var observerTvShow: Observer<TvShowEntity>

    @Mock
    private lateinit var observerTrending: Observer<TrendingEntity>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(catalogRepository)
    }

    @Test
    fun getMoviesById() {
        val movie = MutableLiveData<MovieEntity>()
        movie.value = dummyMovies

        `when`(movieId.let { catalogRepository.getMovieDetail(it) }).thenReturn(movie)

        val movieEntities = movieId.let { viewModel.getMoviesById(it).value } as MovieEntity
        verify(catalogRepository).getMovieDetail(movieId)

        assertNotNull(movieEntities)
        assertEquals(dummyMovies.movieId, movieEntities.movieId)
        assertEquals(dummyMovies.original_title, movieEntities.original_title)
        assertEquals(dummyMovies.overview, movieEntities.overview)
        assertEquals(dummyMovies.popularity.toString(), movieEntities.popularity.toString())
        assertEquals(dummyMovies.poster_path, movieEntities.poster_path)
        assertEquals(dummyMovies.release_date, movieEntities.release_date)
        assertEquals(dummyMovies.vote_average.toString(), movieEntities.vote_average.toString())

        viewModel.getMoviesById(movieId).observeForever(observerMovie)
        verify(observerMovie).onChanged(dummyMovies)
    }

    @Test
    fun getTvShowById() {
        val tvShow = MutableLiveData<TvShowEntity>()
        tvShow.value = dummyTvShow

        `when`(tvShowId.let { catalogRepository.getTvShowDetail(it) }).thenReturn(tvShow)

        val tvShowEntities = tvShowId.let { viewModel.getTvShowById(it).value } as TvShowEntity
        verify(catalogRepository).getTvShowDetail(tvShowId)

        assertNotNull(tvShowEntities)
        assertEquals(dummyTvShow.tvShowId, tvShowEntities.tvShowId)
        assertEquals(dummyTvShow.original_name, tvShowEntities.original_name)
        assertEquals(dummyTvShow.overview, tvShowEntities.overview)
        assertEquals(dummyTvShow.popularity.toString(), tvShowEntities.popularity.toString())
        assertEquals(dummyTvShow.poster_path, tvShowEntities.poster_path)
        assertEquals(dummyTvShow.first_air_date, tvShowEntities.first_air_date)
        assertEquals(dummyTvShow.vote_average.toString(), tvShowEntities.vote_average.toString())

        viewModel.getTvShowById(tvShowId).observeForever(observerTvShow)
        verify(observerTvShow).onChanged(dummyTvShow)
    }

    @Test
    fun getTrendingById() {
        val trending = MutableLiveData<TrendingEntity>()
        trending.value = dummyTrending

        `when`(trendingId.let { catalogRepository.getTrendingDetail(it) }).thenReturn(trending)

        val trendingEntities =
            trendingId.let { viewModel.getTrendingById(it).value } as TrendingEntity
        verify(catalogRepository).getTrendingDetail(trendingId)

        assertNotNull(trendingEntities)
        assertEquals(dummyTrending.trendingId, trendingEntities.trendingId)
        assertEquals(dummyTrending.original_title, trendingEntities.original_title)
        assertEquals(dummyTrending.overview, trendingEntities.overview)
        assertEquals(dummyTrending.popularity.toString(), trendingEntities.popularity.toString())
        assertEquals(dummyTrending.poster_path, trendingEntities.poster_path)
        assertEquals(dummyTrending.release_date, trendingEntities.release_date)
        assertEquals(
            dummyTrending.vote_average.toString(),
            trendingEntities.vote_average.toString()
        )

        viewModel.getTrendingById(trendingId).observeForever(observerTrending)
        verify(observerTrending).onChanged(dummyTrending)
    }

    @Test
    fun setFavoriteMovie() {
        val movie = MutableLiveData<MovieEntity>()
        movie.value = MovieEntity(
            dummyMovies.movieId,
            dummyMovies.original_title,
            dummyMovies.overview,
            dummyMovies.popularity,
            dummyMovies.poster_path,
            dummyMovies.release_date,
            dummyMovies.vote_average
        )
        `when`(movieId.let { catalogRepository.getMovieDetail(it) }).thenReturn(movie)
        val favoriteMovieEntities =
            movieId.let { viewModel.getMoviesById(it).value } as MovieEntity


        verify(catalogRepository).getMovieDetail(movieId)
        viewModel.setFavoriteMovie(favoriteMovieEntities)
        verify(catalogRepository).setFavoriteMovie(favoriteMovieEntities, true)
        Mockito.verifyNoMoreInteractions(observerMovie)
    }

    @Test
    fun setFavoriteTvShow() {
        val tvShow = MutableLiveData<TvShowEntity>()
        tvShow.value = TvShowEntity(
            dummyTvShow.tvShowId,
            dummyTvShow.original_name,
            dummyTvShow.overview,
            dummyTvShow.popularity,
            dummyTvShow.poster_path,
            dummyTvShow.first_air_date,
            dummyTvShow.vote_average
        )
        `when`(tvShowId.let { catalogRepository.getTvShowDetail(it) }).thenReturn(tvShow)
        val favoriteTvShowEntities =
            tvShowId.let { viewModel.getTvShowById(it).value } as TvShowEntity


        verify(catalogRepository).getTvShowDetail(tvShowId)
        viewModel.setFavoriteTvShow(favoriteTvShowEntities)
        verify(catalogRepository).setFavoriteTvShow(favoriteTvShowEntities, true)
        Mockito.verifyNoMoreInteractions(observerTvShow)
    }

    @Test
    fun setFavoriteTrending() {
        val trending = MutableLiveData<TrendingEntity>()
        trending.value = TrendingEntity(
            dummyTrending.trendingId,
            dummyTrending.original_title,
            dummyTrending.overview,
            dummyTrending.popularity,
            dummyTrending.poster_path,
            dummyTrending.release_date,
            dummyTrending.vote_average
        )
        `when`(trendingId.let { catalogRepository.getTrendingDetail(it) }).thenReturn(trending)
        val favoriteTrendingEntities =
            trendingId.let { viewModel.getTrendingById(it).value } as TrendingEntity


        verify(catalogRepository).getTrendingDetail(trendingId)
        viewModel.setFavoriteTrending(favoriteTrendingEntities)
        verify(catalogRepository).setFavoriteTrending(favoriteTrendingEntities, true)
        Mockito.verifyNoMoreInteractions(observerTrending)
    }

    @Test
    fun deleteFavoriteMovie() {
        val movie = MutableLiveData<MovieEntity>()
        movie.value = MovieEntity(
            dummyMovies.movieId,
            dummyMovies.original_title,
            dummyMovies.overview,
            dummyMovies.popularity,
            dummyMovies.poster_path,
            dummyMovies.release_date,
            dummyMovies.vote_average
        ).copy(favorite = true)

        `when`(movieId.let { catalogRepository.getMovieDetail(it) }).thenReturn(movie)

        val entities = movieId.let { viewModel.getMoviesById(it).value } as MovieEntity
        verify(catalogRepository).getMovieDetail(movieId)

        viewModel.setFavoriteMovie(entities)
        verify(catalogRepository).setFavoriteMovie(entities, false)
        Mockito.verifyNoMoreInteractions(observerMovie)
    }

    @Test
    fun deleteFavoriteTvShow() {
        val tvShow = MutableLiveData<TvShowEntity>()
        tvShow.value = TvShowEntity(
            dummyTvShow.tvShowId,
            dummyTvShow.original_name,
            dummyTvShow.overview,
            dummyTvShow.popularity,
            dummyTvShow.poster_path,
            dummyTvShow.first_air_date,
            dummyTvShow.vote_average
        ).copy(favorite = true)

        `when`(tvShowId.let { catalogRepository.getTvShowDetail(it) }).thenReturn(tvShow)

        val entities = tvShowId.let { viewModel.getTvShowById(it).value } as TvShowEntity
        verify(catalogRepository).getTvShowDetail(tvShowId)

        viewModel.setFavoriteTvShow(entities)
        verify(catalogRepository).setFavoriteTvShow(entities, false)
        Mockito.verifyNoMoreInteractions(observerTvShow)
    }

    @Test
    fun deleteFavoriteTrending() {
        val trending = MutableLiveData<TrendingEntity>()
        trending.value = TrendingEntity(
            dummyTrending.trendingId,
            dummyTrending.original_title,
            dummyTrending.overview,
            dummyTrending.popularity,
            dummyTrending.poster_path,
            dummyTrending.release_date,
            dummyTrending.vote_average
        ).copy(favorite = true)

        `when`(trendingId.let { catalogRepository.getTrendingDetail(it) }).thenReturn(trending)

        val entities = trendingId.let { viewModel.getTrendingById(it).value } as TrendingEntity
        verify(catalogRepository).getTrendingDetail(trendingId)

        viewModel.setFavoriteTrending(entities)
        verify(catalogRepository).setFavoriteTrending(entities, false)
        Mockito.verifyNoMoreInteractions(observerTrending)
    }
}