package com.dedesaepulloh.submissionbajp.ui.favorite.movie

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
import com.dedesaepulloh.submissionbajp.R
import com.dedesaepulloh.submissionbajp.databinding.FragmentFavoritesMovieBinding
import com.dedesaepulloh.submissionbajp.ui.favorite.FavoriteViewModel
import com.dedesaepulloh.submissionbajp.viewmodel.ViewModelFactory
import javax.inject.Inject


class FavoritesMovieFragment : Fragment() {

    private var fragmentFavoritesMovieBinding: FragmentFavoritesMovieBinding? = null
    private val binding get() = fragmentFavoritesMovieBinding as FragmentFavoritesMovieBinding
    private lateinit var movieAdapter: FavoriteMovieAdapter

    @Inject
    lateinit var factory: ViewModelFactory

    private val favoriteViewModel: FavoriteViewModel by viewModels { factory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentFavoritesMovieBinding =
            FragmentFavoritesMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as BaseApplication).appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            movieAdapter = FavoriteMovieAdapter()
            favoriteViewModel.getFavoriteMovie().observe(viewLifecycleOwner, { movie ->
                movieAdapter.submitList(movie)
                Log.i("ISI :", movie.toString())
                if (movie.size > 0) {
                    isEmptyFavoritesMovie(false)
                } else {
                    isEmptyFavoritesMovie(true)
                }
            })
            binding.rvMovieFavorite.apply {
                layoutManager = GridLayoutManager(activity, 3)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }

    private fun isEmptyFavoritesMovie(state: Boolean) {
        if (state) {
            binding.movieEmpty.apply {
                imgEmptyList.visibility = View.VISIBLE
                tvEmpty.text = getString(R.string.empty_favorite)
                tvEmpty.visibility = View.VISIBLE
                parentEmpty.visibility = View.VISIBLE
            }
            binding.rvMovieFavorite.visibility = View.GONE
        } else {
            binding.movieEmpty.apply {
                imgEmptyList.visibility = View.GONE
                tvEmpty.visibility = View.GONE
                parentEmpty.visibility = View.GONE
            }
            binding.rvMovieFavorite.visibility = View.VISIBLE
        }
    }
}