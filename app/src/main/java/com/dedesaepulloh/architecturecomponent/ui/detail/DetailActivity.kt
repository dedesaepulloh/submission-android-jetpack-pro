@file:Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

package com.dedesaepulloh.architecturecomponent.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.dedesaepulloh.architecturecomponent.R
import com.dedesaepulloh.architecturecomponent.data.model.MovieEntity
import com.dedesaepulloh.architecturecomponent.databinding.ActivityDetailBinding
import com.dedesaepulloh.architecturecomponent.utils.Helper
import com.dedesaepulloh.architecturecomponent.viewmodel.ViewModelFactory
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
        showLoading(true)
        val movieI = intent?.getStringExtra(Helper.EXTRA_ID)
        val movie = movieI?.toInt()
        val movieKey = intent.getStringExtra(Helper.EXTRA_KEY)
        val factory = ViewModelFactory.getInstance()
        detailViewModel = ViewModelProvider(this, factory).get(DetailViewModel::class.java)

        if (movie != null) {
            if (movieKey == Helper.EXTRA_MOVIE) {
                detailViewModel.getMoviesById(movie).observe(this, {
                    loadData(it)
                    showLoading(false)
                })
            } else {
                detailViewModel.getTvShowById(movie).observe(this, {
                    loadData(it)
                    showLoading(false)
                })
            }
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun loadData(data: MovieEntity?) {
        data?.apply {
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

    private fun showLoading(state: Boolean) {
        if (state) {
            activityDetailBinding.itemDetail.progressBar.visibility = View.VISIBLE
            activityDetailBinding.itemDetail.labelRelease.visibility = View.GONE
            activityDetailBinding.itemDetail.labelPopularity.visibility = View.GONE
            activityDetailBinding.itemDetail.labelRate.visibility = View.GONE
            activityDetailBinding.itemDetail.tvOverview.visibility = View.GONE
            activityDetailBinding.itemDetail.tvTitle.visibility = View.GONE
            activityDetailBinding.itemDetail.tvRelease.visibility = View.GONE
            activityDetailBinding.itemDetail.tvPopularity.visibility = View.GONE
            activityDetailBinding.itemDetail.tvRate.visibility = View.GONE
            activityDetailBinding.itemDetail.tvOverviewDetail.visibility = View.GONE
        } else {
            activityDetailBinding.itemDetail.progressBar.visibility = View.GONE
            activityDetailBinding.itemDetail.labelRelease.visibility = View.VISIBLE
            activityDetailBinding.itemDetail.labelPopularity.visibility = View.VISIBLE
            activityDetailBinding.itemDetail.labelRate.visibility = View.VISIBLE
            activityDetailBinding.itemDetail.tvOverview.visibility = View.VISIBLE
            activityDetailBinding.itemDetail.tvTitle.visibility = View.VISIBLE
            activityDetailBinding.itemDetail.tvRelease.visibility = View.VISIBLE
            activityDetailBinding.itemDetail.tvPopularity.visibility = View.VISIBLE
            activityDetailBinding.itemDetail.tvRate.visibility = View.VISIBLE
            activityDetailBinding.itemDetail.tvOverviewDetail.visibility = View.VISIBLE
        }
    }
}