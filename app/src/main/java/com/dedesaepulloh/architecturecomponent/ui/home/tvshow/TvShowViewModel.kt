package com.dedesaepulloh.architecturecomponent.ui.home.tvshow

import androidx.lifecycle.ViewModel
import com.dedesaepulloh.architecturecomponent.model.MovieEntity
import com.dedesaepulloh.architecturecomponent.utils.DataDummy

class TvShowViewModel : ViewModel() {
    fun getTvShow(): List<MovieEntity> =
        DataDummy.generateDummyTvShow()
}