package com.dedesaepulloh.submissionbajp.ui.movies

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.dedesaepulloh.submissionbajp.BaseApplication
import com.dedesaepulloh.submissionbajp.databinding.FragmentMoviesBinding
import com.dedesaepulloh.submissionbajp.ui.movies.adapter.MovieAdapter
import com.dedesaepulloh.submissionbajp.viewmodel.ViewModelFactory
import com.dedesaepulloh.submissionbajp.vo.Status
import javax.inject.Inject

class MoviesFragment : Fragment() {

    private var fragmentMoviesBinding: FragmentMoviesBinding? = null
    private val binding get() = fragmentMoviesBinding as FragmentMoviesBinding
    private lateinit var adapter: MovieAdapter

    @Inject
    lateinit var factory: ViewModelFactory

    private val movieViewModel: MoviesViewModel by viewModels { factory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMoviesBinding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as BaseApplication).appComponent.inject(this)
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

        movieViewModel.getMovies().observe(viewLifecycleOwner, { movie ->
            if (movie != null) {
                when (movie.status) {
                    Status.LOADING -> showLoading(true)
                    Status.SUCCESS -> {
                        movie.data?.let {
                            adapter.submitList(it)
                            adapter.notifyDataSetChanged()
                            Log.i("DATA : ", it.toString())
                            showLoading(false)
                        }
                        showTryAgain(false)
                    }
                    Status.ERROR -> {
                        showLoading(false)
                        showTryAgain(true)
                    }
                }
            }
        })
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.apply {
                rvMovie.visibility = View.GONE
                progressBar.visibility = View.VISIBLE
            }
        } else {
            binding.apply {
                rvMovie.visibility = View.VISIBLE
                progressBar.visibility = View.GONE
            }
        }
    }

    private fun showTryAgain(state: Boolean) {
        if (state) {
            binding.movieFailed.apply {
                imgTryAgain.visibility = View.VISIBLE
                failedLoad.visibility = View.VISIBLE
            }
            binding.rvMovie.visibility = View.GONE
        } else {
            binding.movieFailed.apply {
                imgTryAgain.visibility = View.GONE
                failedLoad.visibility = View.GONE
            }
            binding.rvMovie.visibility = View.VISIBLE
        }
    }

}