package com.dedesaepulloh.architecturecomponent.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.dedesaepulloh.architecturecomponent.R
import com.dedesaepulloh.architecturecomponent.data.model.MovieEntity
import com.dedesaepulloh.architecturecomponent.databinding.ItemsTrendingBinding
import com.dedesaepulloh.architecturecomponent.utils.Helper

class TrendingAdapter : RecyclerView.Adapter<TrendingAdapter.TrendingViewHolder>() {

    private val list = ArrayList<MovieEntity>()
    private lateinit var onItemClickCallback: OnItemClickCallback

    inner class TrendingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemsTrendingBinding.bind(itemView)

        @SuppressLint("SetTextI18n")
        fun bind(trending: MovieEntity) {
            binding.apply {
                tvTitle.text = trending.original_title
                Glide.with(itemView)
                    .load("${Helper.BASE_IMAGE_URL}${trending.poster_path}")
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .placeholder(R.drawable.ic_image)
                    .into(imgPoster)
            }
            itemView.setOnClickListener { onItemClickCallback.onItemClicked(trending) }
        }
    }

    fun setList(trending: List<MovieEntity>) {
        list.clear()
        list.addAll(trending)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TrendingAdapter.TrendingViewHolder {
        return TrendingViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.items_trending, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TrendingAdapter.TrendingViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: MovieEntity)
    }
}