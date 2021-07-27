@file:Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

package com.dedesaepulloh.architecturecomponent.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.dedesaepulloh.architecturecomponent.R
import com.dedesaepulloh.architecturecomponent.databinding.ActivityDetailBinding
import com.dedesaepulloh.architecturecomponent.model.MovieEntity
import com.dedesaepulloh.architecturecomponent.utils.Helper
import java.text.SimpleDateFormat

class DetailActivity : AppCompatActivity() {

    private lateinit var detailViewModel: DetailViewModel
    private lateinit var activityDetailBinding: ActivityDetailBinding

    @SuppressLint("SetTextI18n", "SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(activityDetailBinding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Detail"

        val movieId = intent.getStringExtra(Helper.EXTRA_ID)
        val movieKey = intent.getStringExtra(Helper.EXTRA_KEY)
        detailViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        if (movieId != null) {
            detailViewModel.setSelectedMovie(movieId)
        }
        val data: MovieEntity = if (movieKey == Helper.EXTRA_MOVIE) {
            detailViewModel.getMoviesById()
        } else {
            detailViewModel.getTvShowById()
        }

        data.apply {
            activityDetailBinding.apply {
                val parser = SimpleDateFormat("yyyy-MM-dd")
                val formatter = SimpleDateFormat("dd MMMM yyyy")
                val output: String = formatter.format(parser.parse(release_date))
                itemDetail.tvTitle.text = original_title
                itemDetail.tvRelease.text = output
                itemDetail.tvPopularity.text = popularity.toString()
                itemDetail.tvRate.text = vote_average.toString()
                itemDetail.tvOverviewDetail.text = overview
                Glide.with(this@DetailActivity)
                    .load("${Helper.BASE_IMAGE_URL}${poster_path}")
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .placeholder(R.drawable.ic_image)
                    .into(itemDetail.riPoster)
            }

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}