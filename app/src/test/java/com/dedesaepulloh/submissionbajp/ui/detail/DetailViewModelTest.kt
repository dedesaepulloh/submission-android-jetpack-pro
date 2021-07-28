package com.dedesaepulloh.submissionbajp.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dedesaepulloh.submissionbajp.data.model.MovieEntity
import com.dedesaepulloh.submissionbajp.data.source.CatalogRepository
import com.dedesaepulloh.submissionbajp.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovies = DataDummy.generateDummyPopularMovies()[0]
    private val dummyTvShow = DataDummy.generateDummyTvShow()[0]
    private val movieId = dummyMovies.id?.toInt()
    private val tvShowId = dummyTvShow.id?.toInt()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogRepository: CatalogRepository

    @Mock
    private lateinit var observer: Observer<MovieEntity>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(catalogRepository)
    }

    @Test
    fun getMoviesById() {
        val movie = MutableLiveData<MovieEntity>()
        movie.value = dummyMovies

        `when`(movieId?.let { catalogRepository.getMovieDetail(it) }).thenReturn(movie)

        val movieEntities = movieId?.let { viewModel.getMoviesById(it).value } as MovieEntity
        assertNotNull(movieEntities)
        assertEquals(dummyMovies.id, movieEntities.id)
        assertEquals(dummyMovies.original_title, movieEntities.original_title)
        assertEquals(dummyMovies.overview, movieEntities.overview)
        assertEquals(dummyMovies.popularity.toString(), movieEntities.popularity.toString())
        assertEquals(dummyMovies.poster_path, movieEntities.poster_path)
        assertEquals(dummyMovies.release_date, movieEntities.release_date)
        assertEquals(dummyMovies.vote_average.toString(), movieEntities.vote_average.toString())

        viewModel.getMoviesById(movieId).observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }

    @Test
    fun getTvShowById() {
        val tvShow = MutableLiveData<MovieEntity>()
        tvShow.value = dummyTvShow

        `when`(tvShowId?.let { catalogRepository.getTvShowDetail(it) }).thenReturn(tvShow)

        val tvShowEntities = tvShowId?.let { viewModel.getTvShowById(it).value } as MovieEntity
        assertNotNull(tvShowEntities)
        assertEquals(dummyTvShow.id, tvShowEntities.id)
        assertEquals(dummyTvShow.original_title, tvShowEntities.original_title)
        assertEquals(dummyTvShow.overview, tvShowEntities.overview)
        assertEquals(dummyTvShow.popularity.toString(), tvShowEntities.popularity.toString())
        assertEquals(dummyTvShow.poster_path, tvShowEntities.poster_path)
        assertEquals(dummyTvShow.release_date, tvShowEntities.release_date)
        assertEquals(dummyTvShow.vote_average.toString(), tvShowEntities.vote_average.toString())

        viewModel.getTvShowById(tvShowId).observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}