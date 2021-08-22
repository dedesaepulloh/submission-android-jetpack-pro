package com.dedesaepulloh.submissionbajp.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.dedesaepulloh.submissionbajp.R
import com.dedesaepulloh.submissionbajp.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovie() {
        onView(withId(R.id.movie_nav)).perform(click())
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                6
            )
        )
    }

    @Test
    fun loadTvShow() {
        onView(withId(R.id.tvshow_nav)).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                6
            )
        )
    }

    @Test
    fun loadTrending() {
        onView(withId(R.id.trending_nav)).perform(click())
        onView(withId(R.id.rv_trending)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_trending)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                6
            )
        )
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.movie_nav)).perform(click())
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                6
            )
        )
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                6,
                click()
            )
        )
        onView(withId(R.id.ri_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_popularity)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_rate)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.add_favorite)).check(matches(isDisplayed()))

        pressBack()
    }

    @Test
    fun loadDetailTvShow() {
        onView(withId(R.id.tvshow_nav)).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                6
            )
        )
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                6,
                click()
            )
        )
        onView(withId(R.id.ri_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_popularity)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_rate)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.add_favorite)).check(matches(isDisplayed()))

        pressBack()
    }

    @Test
    fun loadDetailTrending() {
        onView(withId(R.id.trending_nav)).perform(click())
        onView(withId(R.id.rv_trending)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_trending)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                1
            )
        )
        onView(withId(R.id.rv_trending)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                1,
                click()
            )
        )
        onView(withId(R.id.ri_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_popularity)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_rate)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.add_favorite)).check(matches(isDisplayed()))

        pressBack()
    }

    @Test
    fun insertDeleteFavoritesTrending() {
        onView(withId(R.id.rv_trending)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_trending)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                2,
                click()
            )
        )
        onView(withId(R.id.add_favorite)).perform(click())
        pressBack()

        onView(withId(R.id.favorite_nav)).perform(click())
        onView(withId(R.id.rv_trending_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_trending_favorite)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.add_favorite)).perform(click())
        pressBack()
    }

    @Test
    fun insertDeleteFavoritesMovie() {
        onView(withId(R.id.movie_nav)).perform(click())
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                3,
                click()
            )
        )
        onView(withId(R.id.add_favorite)).perform(click())
        pressBack()

        onView(withId(R.id.favorite_nav)).perform(click())
        onView(withText(R.string.tab_movie)).perform(click())
        onView(withId(R.id.rv_movie_favorite)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.add_favorite)).perform(click())
        pressBack()
    }

    @Test
    fun insertDeleteFavoritesTvShow() {
        onView(withId(R.id.tvshow_nav)).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                2,
                click()
            )
        )
        onView(withId(R.id.add_favorite)).perform(click())
        pressBack()

        onView(withId(R.id.favorite_nav)).perform(click())
        onView(withText(R.string.tab_tvshow)).perform(click())
        onView(withId(R.id.rv_tvshow_favorite)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.add_favorite)).perform(click())
        pressBack()
    }

    @Test
    fun showFavoritesTrending() {
        onView(withId(R.id.favorite_nav)).perform(click())
        onView(withId(R.id.rv_trending_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_trending_favorite)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.ri_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_popularity)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_rate)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.add_favorite)).check(matches(isDisplayed()))
        pressBack()
    }

    @Test
    fun showFavoritesMovie() {
        onView(withId(R.id.favorite_nav)).perform(click())
        onView(withText(R.string.tab_movie)).perform(click())
        onView(withId(R.id.rv_movie_favorite)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.ri_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_popularity)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_rate)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.add_favorite)).check(matches(isDisplayed()))
        pressBack()
    }

    @Test
    fun showFavoritesTvShow() {
        onView(withId(R.id.favorite_nav)).perform(click())
        onView(withText(R.string.tab_tvshow)).perform(click())
        onView(withId(R.id.rv_tvshow_favorite)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.ri_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_popularity)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_rate)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.add_favorite)).check(matches(isDisplayed()))

        pressBack()
    }

}