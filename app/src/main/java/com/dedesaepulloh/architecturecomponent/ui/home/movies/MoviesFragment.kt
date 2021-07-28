package com.dedesaepulloh.architecturecomponent.ui.home.movies

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.dedesaepulloh.architecturecomponent.data.model.MovieEntity
import com.dedesaepulloh.architecturecomponent.databinding.FragmentMoviesBinding
import com.dedesaepulloh.architecturecomponent.ui.adapter.MovieAdapter
import com.dedesaepulloh.architecturecomponent.ui.detail.DetailActivity
import com.dedesaepulloh.architecturecomponent.utils.Helper
import com.dedesaepulloh.architecturecomponent.viewmodel.ViewModelFactory

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
        showLoading(true)
        binding.apply {
            rvMovie.layoutManager = GridLayoutManager(activity, 3)
            rvMovie.setHasFixedSize(true)
            rvMovie.adapter = adapter
        }

        val factory = ViewModelFactory.getInstance()
        moviesViewModel =
            ViewModelProvider(this, factory).get(MoviesViewModel::class.java)

        moviesViewModel.getMovies().observe(viewLifecycleOwner, {
            adapter.setList(it)
            adapter.notifyDataSetChanged()
            showLoading(false)
        })

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

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.rvMovie.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.rvMovie.visibility = View.VISIBLE
            binding.progressBar.visibility = View.GONE
        }
    }

}