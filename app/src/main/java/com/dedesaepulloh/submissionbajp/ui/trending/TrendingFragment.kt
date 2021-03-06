package com.dedesaepulloh.submissionbajp.ui.trending

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.dedesaepulloh.submissionbajp.BaseApplication
import com.dedesaepulloh.submissionbajp.databinding.FragmentTrendingBinding
import com.dedesaepulloh.submissionbajp.ui.trending.adapter.TrendingAdapter
import com.dedesaepulloh.submissionbajp.viewmodel.ViewModelFactory
import com.dedesaepulloh.submissionbajp.vo.Status
import javax.inject.Inject

class TrendingFragment : Fragment() {

    private var fragmentTrendingBinding: FragmentTrendingBinding? = null
    private val binding get() = fragmentTrendingBinding as FragmentTrendingBinding
    private lateinit var adapter: TrendingAdapter

    @Inject
    lateinit var factory: ViewModelFactory

    private val trendingViewModel: TrendingViewModel by viewModels { factory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTrendingBinding = FragmentTrendingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as BaseApplication).appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = TrendingAdapter()
        showLoading(true)
        binding.apply {
            rvTrending.layoutManager = GridLayoutManager(activity, 4)
            rvTrending.setHasFixedSize(true)
            rvTrending.adapter = adapter
        }

        trendingViewModel.getTrending().observe(viewLifecycleOwner, { trending ->
            if (trending != null) {
                when (trending.status) {
                    Status.LOADING -> showLoading(true)
                    Status.SUCCESS -> {
                        trending.data?.let {
                            adapter.submitList(it)
                            adapter.notifyDataSetChanged()
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
                rvTrending.visibility = View.GONE
                progressBar.visibility = View.VISIBLE
            }
        } else {
            binding.apply {
                rvTrending.visibility = View.VISIBLE
                progressBar.visibility = View.GONE
            }
        }
    }

    private fun showTryAgain(state: Boolean) {
        if (state) {
            binding.trendingFailed.apply {
                imgTryAgain.visibility = View.VISIBLE
                failedLoad.visibility = View.VISIBLE
            }
            binding.rvTrending.visibility = View.GONE
        } else {
            binding.trendingFailed.apply {
                imgTryAgain.visibility = View.GONE
                failedLoad.visibility = View.GONE
            }
            binding.rvTrending.visibility = View.VISIBLE
        }
    }
}