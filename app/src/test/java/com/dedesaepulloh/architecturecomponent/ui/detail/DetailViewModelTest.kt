package com.dedesaepulloh.architecturecomponent.ui.detail

import com.dedesaepulloh.architecturecomponent.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovies = DataDummy.generateDummyPopularMovies()[0]
    private val dummyTvShow = DataDummy.generateDummyTvShow()[0]
    private val movieId = dummyMovies.id
    private val tvShowId = dummyTvShow.id

    @Before
    fun setUp() {
        viewModel = DetailViewModel()
        viewModel.setSelectedMovie(movieId)
        viewModel.setSelectedMovie(tvShowId)
    }

    @Test
    fun getMoviesById() {
        viewModel.setSelectedMovie(dummyMovies.id)
        val movieEntities = viewModel.getMoviesById()
        assertNotNull(movieEntities)
        assertEquals(dummyMovies.id, movieEntities.id)
        assertEquals(dummyMovies.original_title, movieEntities.original_title)
        assertEquals(dummyMovies.overview, movieEntities.overview)
        assertEquals(dummyMovies.popularity.toString(), movieEntities.popularity.toString())
        assertEquals(dummyMovies.poster_path, movieEntities.poster_path)
        assertEquals(dummyMovies.release_date, movieEntities.release_date)
        assertEquals(dummyMovies.vote_average.toString(), movieEntities.vote_average.toString())
    }

    @Test
    fun getTvShowById() {
        viewModel.setSelectedMovie(dummyTvShow.id)
        val tvShowEntities = viewModel.getTvShowById()
        assertNotNull(tvShowEntities)
        assertEquals(dummyTvShow.id, tvShowEntities.id)
        assertEquals(dummyTvShow.original_title, tvShowEntities.original_title)
        assertEquals(dummyTvShow.overview, tvShowEntities.overview)
        assertEquals(dummyTvShow.popularity.toString(), tvShowEntities.popularity.toString())
        assertEquals(dummyTvShow.poster_path, tvShowEntities.poster_path)
        assertEquals(dummyTvShow.release_date, tvShowEntities.release_date)
        assertEquals(dummyTvShow.vote_average.toString(), tvShowEntities.vote_average.toString())
    }
}