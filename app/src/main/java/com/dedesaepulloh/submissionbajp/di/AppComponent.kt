package com.dedesaepulloh.submissionbajp.di

import android.content.Context
import com.dedesaepulloh.submissionbajp.data.source.CatalogDataSource
import com.dedesaepulloh.submissionbajp.ui.detail.DetailActivity
import com.dedesaepulloh.submissionbajp.ui.favorite.FavoriteFragment
import com.dedesaepulloh.submissionbajp.ui.favorite.movie.FavoritesMovieFragment
import com.dedesaepulloh.submissionbajp.ui.favorite.trending.FavoritesTrendingFragment
import com.dedesaepulloh.submissionbajp.ui.favorite.tvshow.FavoritesTvShowFragment
import com.dedesaepulloh.submissionbajp.ui.movies.MoviesFragment
import com.dedesaepulloh.submissionbajp.ui.trending.TrendingFragment
import com.dedesaepulloh.submissionbajp.ui.tvshow.TvShowFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@AppScope
@Singleton
@Component(
    modules = [RepositoryModule::class]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun provideRepository(): CatalogDataSource

    fun inject(moviesFragment: MoviesFragment)
    fun inject(tvShowFragment: TvShowFragment)
    fun inject(favoriteFragment: FavoriteFragment)
    fun inject(trendingFragment: TrendingFragment)
    fun inject(detailActivity: DetailActivity)
    fun inject(favoritesMovieFragment: FavoritesMovieFragment)
    fun inject(favoritesTvShowFragment: FavoritesTvShowFragment)
    fun inject(favoritesTrendingFragment: FavoritesTrendingFragment)

}

