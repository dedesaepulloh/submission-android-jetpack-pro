package com.dedesaepulloh.submissionbajp.ui.tvshow.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.dedesaepulloh.submissionbajp.R
import com.dedesaepulloh.submissionbajp.data.source.local.entity.TvShowEntity
import com.dedesaepulloh.submissionbajp.databinding.ItemsMovieBinding
import com.dedesaepulloh.submissionbajp.ui.detail.DetailActivity
import com.dedesaepulloh.submissionbajp.utils.Helper

class TvShowAdapter :
    PagedListAdapter<TvShowEntity, TvShowAdapter.TvShowViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.tvShowId == newItem.tvShowId
            }

            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class TvShowViewHolder(private val binding: ItemsMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(tvShow: TvShowEntity) {
            binding.apply {
                tvVote.text = tvShow.vote_average.toString()
                Glide.with(itemView)
                    .load("${Helper.BASE_IMAGE_URL}${tvShow.poster_path}")
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .placeholder(R.drawable.ic_image)
                    .into(imgPoster)
            }
            itemView.setOnClickListener {
                val detail = Intent(itemView.context, DetailActivity::class.java)
                detail.putExtra(Helper.EXTRA_ID, tvShow.tvShowId)
                    .putExtra(Helper.EXTRA_KEY, Helper.EXTRA_TV)
                itemView.context.startActivity(detail)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val mView = ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(mView)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShow = getItem(position)
        if (tvShow != null) {
            holder.bind(tvShow)
        }
    }

}