package com.dedesaepulloh.architecturecomponent.ui.home.tvshow

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.dedesaepulloh.architecturecomponent.databinding.FragmentTvShowBinding
import com.dedesaepulloh.architecturecomponent.model.MovieEntity
import com.dedesaepulloh.architecturecomponent.ui.adapter.MovieAdapter
import com.dedesaepulloh.architecturecomponent.ui.detail.DetailActivity
import com.dedesaepulloh.architecturecomponent.utils.Helper

class TvShowFragment : Fragment() {

    private lateinit var tvShowViewModel: TvShowViewModel
    private var fragmentTvShowBinding: FragmentTvShowBinding? = null
    private val binding get() = fragmentTvShowBinding as FragmentTvShowBinding
    private lateinit var adapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = MovieAdapter()
        adapter.notifyDataSetChanged()

        binding.apply {
            rvTvshow.layoutManager = GridLayoutManager(activity, 3)
            rvTvshow.setHasFixedSize(true)
            rvTvshow.adapter = adapter
        }

        tvShowViewModel = ViewModelProvider(this).get(TvShowViewModel::class.java)
        val tvShowsPopular = tvShowViewModel.getTvShow()
        adapter.setList(tvShowsPopular)

        adapter.setOnItemClickCallback(object : MovieAdapter.OnItemClickCallback {
            override fun onItemClicked(data: MovieEntity) {
                showDetail(data)
            }
        })
    }

    private fun showDetail(data: MovieEntity) {
        val detail = Intent(context, DetailActivity::class.java)
        detail.putExtra(Helper.EXTRA_ID, data.id).putExtra(Helper.EXTRA_KEY, Helper.EXTRA_TV)
        startActivity(detail)
    }
}