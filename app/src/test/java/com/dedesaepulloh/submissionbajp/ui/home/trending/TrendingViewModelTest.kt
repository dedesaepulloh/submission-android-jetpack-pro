package com.dedesaepulloh.submissionbajp.ui.home.trending

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
class TrendingViewModelTest {

    private lateinit var viewModel: TrendingViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogRepository: CatalogRepository

    @Mock
    private lateinit var observer: Observer<List<MovieEntity>>

    @Before
    fun setUp() {
        viewModel = TrendingViewModel(catalogRepository)
    }

    @Test
    fun getTrending() {
        val dummyTrending = DataDummy.generateDummyTrending()
        val trending = MutableLiveData<List<MovieEntity>>()
        trending.value = dummyTrending

        `when`(catalogRepository.getTrending()).thenReturn(trending)

        val trendingEntities = viewModel.getTrending().value
        verify(catalogRepository).getTrending()
        assertNotNull(trendingEntities)
        assertEquals(12, trendingEntities?.size)

        viewModel.getTrending().observeForever(observer)
        verify(observer).onChanged(dummyTrending)
    }
}