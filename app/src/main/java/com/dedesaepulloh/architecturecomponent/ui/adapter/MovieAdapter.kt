package com.dedesaepulloh.architecturecomponent.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.dedesaepulloh.architecturecomponent.R
import com.dedesaepulloh.architecturecomponent.databinding.ItemsMovieBinding
import com.dedesaepulloh.architecturecomponent.model.MovieEntity
import com.dedesaepulloh.architecturecomponent.utils.Helper

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private val list = ArrayList<MovieEntity>()
    private lateinit var onItemClickCallback: OnItemClickCallback

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemsMovieBinding.bind(itemView)

        @SuppressLint("SetTextI18n")
        fun bind(movie: MovieEntity) {
            binding.apply {
                tvVote.text = " " + movie.vote_average.toString()
                Glide.with(itemView)
                    .load("${Helper.BASE_IMAGE_URL}${movie.poster_path}")
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .placeholder(R.drawable.ic_image)
                    .into(imgPoster)
            }
            itemView.setOnClickListener { onItemClickCallback.onItemClicked(movie) }
        }
    }

    fun setList(movies: List<MovieEntity>) {
        list.clear()
        list.addAll(movies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.items_movie, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
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