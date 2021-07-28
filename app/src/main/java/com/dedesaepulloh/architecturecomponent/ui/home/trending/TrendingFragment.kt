package com.dedesaepulloh.architecturecomponent.ui.home.trending

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.dedesaepulloh.architecturecomponent.data.model.MovieEntity
import com.dedesaepulloh.architecturecomponent.databinding.FragmentTrendingBinding
import com.dedesaepulloh.architecturecomponent.ui.adapter.TrendingAdapter
import com.dedesaepulloh.architecturecomponent.ui.detail.DetailActivity
import com.dedesaepulloh.architecturecomponent.utils.Helper
import com.dedesaepulloh.architecturecomponent.viewmodel.ViewModelFactory

class TrendingFragment : Fragment() {

    private lateinit var trendingViewModel: TrendingViewModel
    private lateinit var binding: FragmentTrendingBinding
    private lateinit var adapter: TrendingAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTrendingBinding.inflate(inflater, container, false)
        return binding.root
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

        val factory = ViewModelFactory.getInstance()
        trendingViewModel =
            ViewModelProvider(this, factory).get(TrendingViewModel::class.java)

        trendingViewModel.getTrending().observe(viewLifecycleOwner, {
            adapter.setList(it)
            adapter.notifyDataSetChanged()
            showLoading(false)
        })

        adapter.setOnItemClickCallback(object : TrendingAdapter.OnItemClickCallback {
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
            binding.rvTrending.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.rvTrending.visibility = View.VISIBLE
            binding.progressBar.visibility = View.GONE
        }
    }
}