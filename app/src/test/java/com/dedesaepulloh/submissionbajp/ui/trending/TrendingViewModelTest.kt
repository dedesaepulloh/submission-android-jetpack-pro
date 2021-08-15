package com.dedesaepulloh.submissionbajp.ui.trending

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dedesaepulloh.submissionbajp.data.source.CatalogRepository
import com.dedesaepulloh.submissionbajp.data.source.local.entity.TrendingEntity
import com.dedesaepulloh.submissionbajp.vo.Resource
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
    private lateinit var observer: Observer<Resource<PagedList<TrendingEntity>>>

    @Mock
    private lateinit var trendingPagedList: PagedList<TrendingEntity>

    @Before
    fun setUp() {
        viewModel = TrendingViewModel(catalogRepository)
    }

    @Test
    fun getTrending() {
        val dummyTrending = Resource.success(trendingPagedList)
        val trending = MutableLiveData<Resource<PagedList<TrendingEntity>>>()
        trending.value = dummyTrending

        `when`(dummyTrending.data?.size).thenReturn(12)
        `when`(catalogRepository.getTrending()).thenReturn(trending)

        val trendingEntities = viewModel.getTrending().value?.data
        verify(catalogRepository).getTrending()
        assertNotNull(trendingEntities)
        assertEquals(12, trendingEntities?.size)

        viewModel.getTrending().observeForever(observer)
        verify(observer).onChanged(dummyTrending)
    }
}