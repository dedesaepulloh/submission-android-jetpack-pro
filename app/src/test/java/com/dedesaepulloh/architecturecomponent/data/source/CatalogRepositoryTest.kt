package com.dedesaepulloh.architecturecomponent.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dedesaepulloh.architecturecomponent.data.source.remote.RemoteDataSource
import com.dedesaepulloh.architecturecomponent.utils.DataDummy
import com.dedesaepulloh.architecturecomponent.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.mockito.Mockito.mock

class CatalogRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val catalogRepository = FakeCatalogRepository(remote)

    private val listMovie = DataDummy.generateDummyMovieResponse()
    private val movieId = listMovie[0].id.toString()
    private val movieResponse = DataDummy.generateDummyMovieResponse()[0]

    private val listTvShow = DataDummy.generateDummyTvShowResponse()
    private val tvShowId = listTvShow[0].id.toString()
    private val tvShowResponse = DataDummy.generateDummyTvShowResponse()[0]

    private val listTrending = DataDummy.generateDummyMovieResponse()

    @Test
    fun getMoviePopular() {
        runBlocking {
            doAnswer { invocation ->
                (invocation.arguments[0] as RemoteDataSource.LoadMoviePopularCallback).onAllMovieReceived(
                    listMovie
                )
                null
            }.`when`(remote).getMoviePopular(any())

            val movie = LiveDataTestUtil.getValue(catalogRepository.getMoviePopular())
            runBlocking {
                verify(remote).getMoviePopular(any())
            }
            assertNotNull(movie)
            assertEquals(listMovie.size, movie.size)
        }
    }

    @Test
    fun getMovieDetail() {
        runBlocking {
            doAnswer { invocation ->
                (invocation.arguments[1] as RemoteDataSource.LoadDetailMovieCallback).onDetailMovieReceived(
                    movieResponse
                )
                null
            }.`when`(remote).getMovieDetail(eq(movieId.toInt()), any())
        }

        val detail = LiveDataTestUtil.getValue(catalogRepository.getMovieDetail(movieId.toInt()))

        runBlocking {
            verify(remote).getMovieDetail(eq(movieId.toInt()), any())
        }

        assertNotNull(detail)
        assertEquals(movieResponse.id.toString(), detail.id)
    }

    @Test
    fun getTvShowPopular() {
        runBlocking {
            doAnswer { invocation ->
                (invocation.arguments[0] as RemoteDataSource.LoadTvShowPopularCallback).onAllTvShowReceived(
                    listTvShow
                )
                null
            }.`when`(remote).getTvShowPopular(any())

            val tvShow = LiveDataTestUtil.getValue(catalogRepository.getTvShowPopular())
            runBlocking {
                verify(remote).getTvShowPopular(any())
            }
            assertNotNull(tvShow)
            assertEquals(listTvShow.size, tvShow.size)
        }
    }

    @Test
    fun getTvShowDetail() {
        runBlocking {
            doAnswer { invocation ->
                (invocation.arguments[1] as RemoteDataSource.LoadDetailTvShowCallback).onDetailTvShowReceived(
                    tvShowResponse
                )
                null
            }.`when`(remote).getTvShowDetail(eq(tvShowId.toInt()), any())
        }

        val detail = LiveDataTestUtil.getValue(catalogRepository.getTvShowDetail(tvShowId.toInt()))

        runBlocking {
            verify(remote).getTvShowDetail(eq(tvShowId.toInt()), any())
        }

        assertNotNull(detail)
        assertEquals(tvShowResponse.id.toString(), detail.id)
    }

    @Test
    fun getTrending() {
        runBlocking {
            doAnswer { invocation ->
                (invocation.arguments[0] as RemoteDataSource.LoadTrendingCallback).onAllTrendingReceived(
                    listTrending
                )
                null
            }.`when`(remote).getTrendingMovie(any())

            val trending = LiveDataTestUtil.getValue(catalogRepository.getTrending())
            runBlocking {
                verify(remote).getTrendingMovie(any())
            }
            assertNotNull(trending)
            assertEquals(listTrending.size, trending.size)
        }
    }
}