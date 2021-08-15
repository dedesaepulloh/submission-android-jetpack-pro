@file:Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

package com.dedesaepulloh.submissionbajp.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.dedesaepulloh.submissionbajp.BaseApplication
import com.dedesaepulloh.submissionbajp.R
import com.dedesaepulloh.submissionbajp.data.source.local.entity.MovieEntity
import com.dedesaepulloh.submissionbajp.data.source.local.entity.TrendingEntity
import com.dedesaepulloh.submissionbajp.data.source.local.entity.TvShowEntity
import com.dedesaepulloh.submissionbajp.databinding.ActivityDetailBinding
import com.dedesaepulloh.submissionbajp.utils.Helper
import com.dedesaepulloh.submissionbajp.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import javax.inject.Inject

class DetailActivity : AppCompatActivity() {

    private lateinit var activityDetailBinding: ActivityDetailBinding

    @Inject
    lateinit var factory: ViewModelFactory

    private val detailViewModel: DetailViewModel by viewModels {
        factory
    }

    @SuppressLint("SetTextI18n", "SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        (application as BaseApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(activityDetailBinding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        showLoading(true)


        val movie = intent?.getIntExtra(Helper.EXTRA_ID, 1)
        val movieKey = intent.getStringExtra(Helper.EXTRA_KEY)

        if (movie != null) {
            when {
                movieKey.equals(Helper.EXTRA_MOVIE, ignoreCase = true) -> {
                    detailViewModel.getMoviesById(movie).observe(this, {
                        supportActionBar?.title = getString(R.string.detail_movie)
                        movieLoadData(it)
                        setActionButton(it, null, null)
                        showLoading(false)
                    })
                }
                movieKey.equals(Helper.EXTRA_TV, ignoreCase = true) -> {
                    detailViewModel.getTvShowById(movie).observe(this, {
                        supportActionBar?.title = getString(R.string.detail_tv_show)
                        tvShowLoadData(it)
                        setActionButton(null, it, null)
                        showLoading(false)
                    })
                }
                else -> {
                    detailViewModel.getTrendingById(movie).observe(this, {
                        supportActionBar?.title = getString(R.string.detail_trending)
                        trendingLoadData(it)
                        setActionButton(null, null, it)
                        showLoading(false)
                    })
                }
            }
        }
    }

    private fun setActionButton(
        movie: MovieEntity?,
        tvShow: TvShowEntity?,
        trending: TrendingEntity?
    ) {
        activityDetailBinding.itemDetail.addFavorite.setOnClickListener {
            setFavorite(movie, tvShow, trending)
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun movieLoadData(data: MovieEntity?) {
        data?.apply {
            activityDetailBinding.itemDetail.apply {
                val parser = SimpleDateFormat("yyyy-MM-dd")
                val formatter = SimpleDateFormat("dd MMMM yyyy")
                val output: String = if (release_date.isNullOrEmpty()) {
                    getString(R.string.strip)
                } else {
                    formatter.format(parser.parse(release_date))
                }
                tvTitle.text = original_title
                tvRelease.text = output
                tvPopularity.text = popularity.toString()
                tvRate.text = vote_average.toString()
                tvOverviewDetail.text = overview
                Glide.with(this@DetailActivity)
                    .load("${Helper.BASE_IMAGE_URL}${poster_path}")
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .placeholder(R.drawable.ic_image)
                    .into(riPoster)
            }
            setFavoriteState(favorite)

        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun tvShowLoadData(data: TvShowEntity?) {
        data?.apply {
            activityDetailBinding.itemDetail.apply {
                val parser = SimpleDateFormat("yyyy-MM-dd")
                val formatter = SimpleDateFormat("dd MMMM yyyy")
                val output: String = if (first_air_date.isNullOrEmpty()) {
                    getString(R.string.strip)
                } else {
                    formatter.format(parser.parse(first_air_date))
                }
                tvTitle.text = original_name
                labelRelease.text = getString(R.string.first_air_date)
                tvRelease.text = output
                tvPopularity.text = popularity.toString()
                tvRate.text = vote_average.toString()
                tvOverviewDetail.text = overview
                Glide.with(this@DetailActivity)
                    .load("${Helper.BASE_IMAGE_URL}${poster_path}")
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .placeholder(R.drawable.ic_image)
                    .into(riPoster)
            }
            setFavoriteState(favorite)

        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun trendingLoadData(data: TrendingEntity?) {
        data?.apply {
            activityDetailBinding.itemDetail.apply {
                val parser = SimpleDateFormat("yyyy-MM-dd")
                val formatter = SimpleDateFormat("dd MMMM yyyy")
                val output: String = if (release_date.isNullOrEmpty()) {
                    getString(R.string.strip)
                } else {
                    formatter.format(parser.parse(release_date))
                }
                tvTitle.text = original_title
                tvRelease.text = output
                tvPopularity.text = popularity.toString()
                tvRate.text = vote_average.toString()
                tvOverviewDetail.text = overview
                Glide.with(this@DetailActivity)
                    .load("${Helper.BASE_IMAGE_URL}${poster_path}")
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .placeholder(R.drawable.ic_image)
                    .into(riPoster)
            }
            setFavoriteState(favorite)

        }
    }

    private fun setFavorite(movie: MovieEntity?, tvShow: TvShowEntity?, trending: TrendingEntity?) {
        if (movie != null) {
            if (movie.favorite) {
                showSnackBar("${movie.original_title} " + getString(R.string.removed_favorite))
            } else {
                showSnackBar("${movie.original_title} " + getString(R.string.add_favorite))
            }
            detailViewModel.setFavoriteMovie(movie)
        } else if (tvShow != null) {
            if (tvShow.favorite) {
                showSnackBar("${tvShow.original_name} " + getString(R.string.removed_favorite))
            } else {
                showSnackBar("${tvShow.original_name} " + getString(R.string.add_favorite))
            }
            detailViewModel.setFavoriteTvShow(tvShow)
        } else {
            if (trending != null) {
                if (trending.favorite) {
                    showSnackBar("${trending.original_title} " + getString(R.string.removed_favorite))
                } else {
                    showSnackBar("${trending.original_title} " + getString(R.string.add_favorite))
                }
                detailViewModel.setFavoriteTrending(trending)
            }
        }
    }

    private fun setFavoriteState(isFavorite: Boolean) {
        if (isFavorite) {
            activityDetailBinding.itemDetail.addFavorite.setImageResource(R.drawable.ic_full_favorite)
        } else {
            activityDetailBinding.itemDetail.addFavorite.setImageResource(R.drawable.ic_favorite_border)
        }
    }

    private fun showSnackBar(msg: String) {
        Snackbar.make(activityDetailBinding.root, msg, Snackbar.LENGTH_LONG)
            .show()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            activityDetailBinding.itemDetail.apply {
                progressBar.visibility = View.VISIBLE
                labelRelease.visibility = View.GONE
                labelPopularity.visibility = View.GONE
                labelRate.visibility = View.GONE
                tvOverview.visibility = View.GONE
                tvTitle.visibility = View.GONE
                tvRelease.visibility = View.GONE
                tvPopularity.visibility = View.GONE
                tvRate.visibility = View.GONE
                tvOverviewDetail.visibility = View.GONE
            }

        } else {
            activityDetailBinding.itemDetail.apply {
                progressBar.visibility = View.GONE
                labelRelease.visibility = View.VISIBLE
                labelPopularity.visibility = View.VISIBLE
                labelRate.visibility = View.VISIBLE
                tvOverview.visibility = View.VISIBLE
                tvTitle.visibility = View.VISIBLE
                tvRelease.visibility = View.VISIBLE
                tvPopularity.visibility = View.VISIBLE
                tvRate.visibility = View.VISIBLE
                tvOverviewDetail.visibility = View.VISIBLE
            }
        }
    }
}