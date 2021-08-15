package com.dedesaepulloh.submissionbajp.ui.favorite

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.dedesaepulloh.submissionbajp.R
import com.dedesaepulloh.submissionbajp.ui.favorite.movie.FavoritesMovieFragment
import com.dedesaepulloh.submissionbajp.ui.favorite.trending.FavoritesTrendingFragment
import com.dedesaepulloh.submissionbajp.ui.favorite.tvshow.FavoritesTvShowFragment

class SectionsPagerAdapter(private val mContext: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.trending, R.string.tab_movie, R.string.tab_tvshow)
    }

    override fun getCount(): Int = 3

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> FavoritesTrendingFragment()
            1 -> FavoritesMovieFragment()
            2 -> FavoritesTvShowFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence = mContext.resources.getString(
        TAB_TITLES[position]
    )

}