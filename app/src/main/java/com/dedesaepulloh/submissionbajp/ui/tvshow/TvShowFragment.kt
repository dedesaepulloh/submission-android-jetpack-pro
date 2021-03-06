package com.dedesaepulloh.submissionbajp.ui.tvshow

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.dedesaepulloh.submissionbajp.BaseApplication
import com.dedesaepulloh.submissionbajp.databinding.FragmentTvShowBinding
import com.dedesaepulloh.submissionbajp.ui.tvshow.adapter.TvShowAdapter
import com.dedesaepulloh.submissionbajp.viewmodel.ViewModelFactory
import com.dedesaepulloh.submissionbajp.vo.Status
import javax.inject.Inject

class TvShowFragment : Fragment() {

    private var fragmentTvShowBinding: FragmentTvShowBinding? = null
    private val binding get() = fragmentTvShowBinding as FragmentTvShowBinding
    private lateinit var adapter: TvShowAdapter

    @Inject
    lateinit var factory: ViewModelFactory

    private val tvShowViewModel: TvShowViewModel by viewModels { factory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as BaseApplication).appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = TvShowAdapter()
        showLoading(true)
        binding.apply {
            rvTvshow.layoutManager = GridLayoutManager(activity, 3)
            rvTvshow.setHasFixedSize(true)
            rvTvshow.adapter = adapter
        }

        tvShowViewModel.getTvShow().observe(viewLifecycleOwner, { tvShow ->
            if (tvShow != null) {
                when (tvShow.status) {
                    Status.LOADING -> showLoading(true)
                    Status.SUCCESS -> {
                        tvShow.data?.let {
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
                rvTvshow.visibility = View.GONE
                progressBar.visibility = View.VISIBLE
            }
        } else {
            binding.apply {
                rvTvshow.visibility = View.VISIBLE
                progressBar.visibility = View.GONE
            }
        }
    }

    private fun showTryAgain(state: Boolean) {
        if (state) {
            binding.tvshowFailed.apply {
                imgTryAgain.visibility = View.VISIBLE
                failedLoad.visibility = View.VISIBLE
            }
            binding.rvTvshow.visibility = View.GONE
        } else {
            binding.tvshowFailed.apply {
                imgTryAgain.visibility = View.GONE
                failedLoad.visibility = View.GONE
            }
            binding.rvTvshow.visibility = View.VISIBLE
        }
    }
}