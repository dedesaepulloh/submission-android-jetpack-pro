package com.dedesaepulloh.architecturecomponent.ui.detail

import androidx.lifecycle.ViewModel
import com.dedesaepulloh.architecturecomponent.model.MovieEntity
import com.dedesaepulloh.architecturecomponent.utils.DataDummy

class DetailViewModel : ViewModel() {
    private lateinit var movieId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }

    fun getMoviesById(): MovieEntity {
        lateinit var movie: MovieEntity
        val movieEntities = DataDummy.generateDummyPopularMovies()
        for (movieEntity in movieEntities) {
            if (movieEntity.id == movieId) {
                movie = movieEntity
                break
            }
        }
        return movie
    }

    fun getTvShowById(): MovieEntity {
        val tvShowEntities = DataDummy.generateDummyTvShow()
        lateinit var tvShow: MovieEntity
        for (tvShowEntity in tvShowEntities) {
            if (tvShowEntity.id == movieId) {
                tvShow = tvShowEntity
                break
            }
        }
        return tvShow
    }
}