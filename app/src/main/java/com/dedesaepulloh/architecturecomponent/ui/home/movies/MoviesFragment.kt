package com.dedesaepulloh.architecturecomponent.ui.home.movies

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.dedesaepulloh.architecturecomponent.databinding.FragmentMoviesBinding
import com.dedesaepulloh.architecturecomponent.model.MovieEntity
import com.dedesaepulloh.architecturecomponent.ui.adapter.MovieAdapter
import com.dedesaepulloh.architecturecomponent.ui.detail.DetailActivity
import com.dedesaepulloh.architecturecomponent.utils.Helper

class MoviesFragment : Fragment() {

    private lateinit var moviesViewModel: MoviesViewModel
    private var fragmentMoviesBinding: FragmentMoviesBinding? = null
    private val binding get() = fragmentMoviesBinding as FragmentMoviesBinding
    private lateinit var adapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMoviesBinding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = MovieAdapter()
        adapter.notifyDataSetChanged()

        binding.apply {
            rvMovie.layoutManager = GridLayoutManager(activity, 3)
            rvMovie.setHasFixedSize(true)
            rvMovie.adapter = adapter
        }
        moviesViewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)

        val moviePlaying = moviesViewModel.getMovies()
        adapter.setList(moviePlaying)


        adapter.setOnItemClickCallback(object : MovieAdapter.OnItemClickCallback {
            override fun onItemClicked(data: MovieEntity) {
                showDetail(data)
            }
        })

    }

    private fun showDetail(data: MovieEntity) {
        val detail = Intent(context, DetailActivity::class.java)
        detail.putExtra(Helper.EXTRA_ID, data.id).putExtra(Helper.EXTRA_KEY, Helper.EXTRA_MOVIE)
        startActivity(detail)
    }

}