package com.dedesaepulloh.submissionbajp.ui.favorite.tvshow

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.dedesaepulloh.submissionbajp.BaseApplication
import com.dedesaepulloh.submissionbajp.R
import com.dedesaepulloh.submissionbajp.databinding.FragmentFavoritesTvShowBinding
import com.dedesaepulloh.submissionbajp.ui.favorite.FavoriteViewModel
import com.dedesaepulloh.submissionbajp.viewmodel.ViewModelFactory
import javax.inject.Inject


class FavoritesTvShowFragment : Fragment() {

    private var fragmentFavoritesTvShowBinding: FragmentFavoritesTvShowBinding? = null
    private val binding get() = fragmentFavoritesTvShowBinding as FragmentFavoritesTvShowBinding
    private lateinit var tvShowAdapter: FavoriteTvShowAdapter

    @Inject
    lateinit var factory: ViewModelFactory

    private val favoriteViewModel: FavoriteViewModel by viewModels { factory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentFavoritesTvShowBinding =
            FragmentFavoritesTvShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as BaseApplication).appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            tvShowAdapter = FavoriteTvShowAdapter()
            favoriteViewModel.getFavoriteTvShow().observe(viewLifecycleOwner, { tvShow ->
                tvShowAdapter.submitList(tvShow)
                if (tvShow.size > 0) {
                    isEmptyFavoritesTvShow(false)
                } else {
                    isEmptyFavoritesTvShow(true)
                }
            })

            binding.rvTvshowFavorite.apply {
                layoutManager = GridLayoutManager(activity, 3)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }

        }

    }

    private fun isEmptyFavoritesTvShow(state: Boolean) {
        if (state) {
            binding.tvshowEmpty.apply {
                imgEmptyList.visibility = View.VISIBLE
                tvEmpty.text = getString(R.string.empty_favorite)
                tvEmpty.visibility = View.VISIBLE
                parentEmpty.visibility = View.VISIBLE
            }
            binding.rvTvshowFavorite.visibility = View.GONE
        } else {
            binding.tvshowEmpty.apply {
                imgEmptyList.visibility = View.GONE
                tvEmpty.visibility = View.GONE
                parentEmpty.visibility = View.GONE
            }
            binding.rvTvshowFavorite.visibility = View.VISIBLE
        }
    }
}