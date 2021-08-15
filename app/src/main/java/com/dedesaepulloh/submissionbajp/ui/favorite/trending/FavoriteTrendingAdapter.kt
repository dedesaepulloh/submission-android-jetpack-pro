package com.dedesaepulloh.submissionbajp.ui.favorite.trending

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.dedesaepulloh.submissionbajp.R
import com.dedesaepulloh.submissionbajp.data.source.local.entity.TrendingEntity
import com.dedesaepulloh.submissionbajp.databinding.ItemsFavoriteBinding
import com.dedesaepulloh.submissionbajp.ui.detail.DetailActivity
import com.dedesaepulloh.submissionbajp.utils.Helper

class FavoriteTrendingAdapter :
    PagedListAdapter<TrendingEntity, FavoriteTrendingAdapter.TrendingViewHolder>(
        DIFF_CALLBACK
    ) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TrendingEntity>() {
            override fun areItemsTheSame(
                oldItem: TrendingEntity,
                newItem: TrendingEntity
            ): Boolean {
                return oldItem.trendingId == newItem.trendingId
            }

            override fun areContentsTheSame(
                oldItem: TrendingEntity,
                newItem: TrendingEntity
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class TrendingViewHolder(private val binding: ItemsFavoriteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(trending: TrendingEntity) {
            binding.apply {
                tvVote.text = trending.vote_average.toString()
                Glide.with(itemView)
                    .load("${Helper.BASE_IMAGE_URL}${trending.poster_path}")
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .placeholder(R.drawable.ic_image)
                    .into(imgPoster)
            }
            itemView.setOnClickListener {
                val detail = Intent(itemView.context, DetailActivity::class.java)
                detail.putExtra(Helper.EXTRA_ID, trending.trendingId)
                    .putExtra(Helper.EXTRA_KEY, Helper.EXTRA_TRENDING)
                itemView.context.startActivity(detail)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingViewHolder {
        val mView = ItemsFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrendingViewHolder(mView)
    }

    override fun onBindViewHolder(holder: TrendingViewHolder, position: Int) {
        val trending = getItem(position)
        if (trending != null) {
            holder.bind(trending)
        }
    }
}