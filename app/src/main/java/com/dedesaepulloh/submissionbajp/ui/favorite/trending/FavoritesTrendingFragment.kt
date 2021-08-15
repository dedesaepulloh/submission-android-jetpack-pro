package com.dedesaepulloh.submissionbajp.ui.favorite.trending

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
import com.dedesaepulloh.submissionbajp.databinding.FragmentFavoritesTrendingBinding
import com.dedesaepulloh.submissionbajp.ui.favorite.FavoriteViewModel
import com.dedesaepulloh.submissionbajp.viewmodel.ViewModelFactory
import javax.inject.Inject


class FavoritesTrendingFragment : Fragment() {

    private var fragmentFavoritesTrendingBinding: FragmentFavoritesTrendingBinding? = null
    private val binding get() = fragmentFavoritesTrendingBinding as FragmentFavoritesTrendingBinding
    private lateinit var trendingAdapter: FavoriteTrendingAdapter

    @Inject
    lateinit var factory: ViewModelFactory

    private val favoriteViewModel: FavoriteViewModel by viewModels { factory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentFavoritesTrendingBinding =
            FragmentFavoritesTrendingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as BaseApplication).appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            trendingAdapter = FavoriteTrendingAdapter()
            favoriteViewModel.getFavoriteTrending().observe(viewLifecycleOwner, { trending ->
                trendingAdapter.submitList(trending)
                if (trending.size > 0) {
                    isEmptyFavoritesTrending(false)
                } else {
                    isEmptyFavoritesTrending(true)
                }
            })

            binding.rvTrendingFavorite.apply {
                layoutManager = GridLayoutManager(activity, 3)
                setHasFixedSize(true)
                adapter = trendingAdapter
            }

        }
    }

    private fun isEmptyFavoritesTrending(state: Boolean) {
        if (state) {
            binding.trendingEmpty.apply {
                imgEmptyList.visibility = View.VISIBLE
                tvEmpty.text = getString(R.string.empty_favorite)
                tvEmpty.visibility = View.VISIBLE
                parentEmpty.visibility = View.VISIBLE
            }
            binding.rvTrendingFavorite.visibility = View.GONE
        } else {
            binding.trendingEmpty.apply {
                imgEmptyList.visibility = View.GONE
                tvEmpty.visibility = View.GONE
                parentEmpty.visibility = View.GONE
            }
            binding.rvTrendingFavorite.visibility = View.VISIBLE
        }
    }

}