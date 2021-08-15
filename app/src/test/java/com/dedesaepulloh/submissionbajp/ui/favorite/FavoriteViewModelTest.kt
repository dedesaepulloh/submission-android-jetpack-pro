package com.dedesaepulloh.submissionbajp.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dedesaepulloh.submissionbajp.data.source.CatalogRepository
import com.dedesaepulloh.submissionbajp.data.source.local.entity.MovieEntity
import com.dedesaepulloh.submissionbajp.data.source.local.entity.TrendingEntity
import com.dedesaepulloh.submissionbajp.data.source.local.entity.TvShowEntity
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
class FavoriteViewModelTest {

    private lateinit var viewModel: FavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogRepository: CatalogRepository

    @Mock
    private lateinit var observerMovie: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var observerTvShow: Observer<PagedList<TvShowEntity>>

    @Mock
    private lateinit var observerTrending: Observer<PagedList<TrendingEntity>>

    @Mock
    private lateinit var moviePagedList: PagedList<MovieEntity>

    @Mock
    private lateinit var tvShowPagedList: PagedList<TvShowEntity>

    @Mock
    private lateinit var trendingPagedList: PagedList<TrendingEntity>

    @Before
    fun setUp() {
        viewModel = FavoriteViewModel(catalogRepository)
    }

    @Test
    fun getFavoriteMovie() {
        val dummyMovie = moviePagedList
        val movie = MutableLiveData<PagedList<MovieEntity>>()
        movie.value = dummyMovie

        `when`(dummyMovie.size).thenReturn(1)
        `when`(catalogRepository.getFavoriteMovie()).thenReturn(movie)

        val movieEntities = viewModel.getFavoriteMovie().value
        verify(catalogRepository).getFavoriteMovie()
        assertNotNull(movieEntities)
        assertEquals(1, movieEntities?.size)

        viewModel.getFavoriteMovie().observeForever(observerMovie)
        verify(observerMovie).onChanged(dummyMovie)
    }

    @Test
    fun getFavoriteTvShow() {
        val dummyTvShow = tvShowPagedList
        val tvShow = MutableLiveData<PagedList<TvShowEntity>>()
        tvShow.value = dummyTvShow

        `when`(dummyTvShow.size).thenReturn(1)
        `when`(catalogRepository.getFavoriteTvShow()).thenReturn(tvShow)

        val tvShowEntities = viewModel.getFavoriteTvShow().value
        verify(catalogRepository).getFavoriteTvShow()
        assertNotNull(tvShowEntities)
        assertEquals(1, tvShowEntities?.size)

        viewModel.getFavoriteTvShow().observeForever(observerTvShow)
        verify(observerTvShow).onChanged(dummyTvShow)
    }

    @Test
    fun getFavoriteTrending() {
        val dummyTrending = trendingPagedList
        val trending = MutableLiveData<PagedList<TrendingEntity>>()
        trending.value = dummyTrending

        `when`(dummyTrending.size).thenReturn(1)
        `when`(catalogRepository.getFavoriteTrending()).thenReturn(trending)

        val trendingEntities = viewModel.getFavoriteTrending().value
        verify(catalogRepository).getFavoriteTrending()
        assertNotNull(trendingEntities)
        assertEquals(1, trendingEntities?.size)

        viewModel.getFavoriteTrending().observeForever(observerTrending)
        verify(observerTrending).onChanged(dummyTrending)
    }
}