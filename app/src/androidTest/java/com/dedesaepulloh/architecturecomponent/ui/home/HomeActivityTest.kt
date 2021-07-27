@file:Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

package com.dedesaepulloh.architecturecomponent.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.dedesaepulloh.architecturecomponent.R
import com.dedesaepulloh.architecturecomponent.utils.DataDummy
import org.junit.Rule
import org.junit.Test
import java.text.SimpleDateFormat

class HomeActivityTest {
    private val dummyMovie = DataDummy.generateDummyPopularMovies()
    private val dummyTvShow = DataDummy.generateDummyTvShow()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadMovie() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )
    }

    @Test
    fun loadTvShow() {
        onView(withId(R.id.tvshow_nav)).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
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
        onView(withId(R.id.tv_title)).check(matches(withText(dummyMovie[6].original_title)))

        onView(withId(R.id.tv_release)).check(matches(isDisplayed()))
        val parser = SimpleDateFormat("yyyy-MM-dd")
        val formater = SimpleDateFormat("dd MMMM yyyy")
        val output: String = formater.format(parser.parse(dummyMovie[6].release_date))
        onView(withId(R.id.tv_release)).check(matches(withText(output)))

        onView(withId(R.id.tv_popularity)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_popularity)).check(matches(withText(dummyMovie[6].popularity.toString())))
        onView(withId(R.id.tv_rate)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_rate)).check(matches(withText(dummyMovie[6].vote_average.toString())))

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
        onView(withId(R.id.tv_title)).check(matches(withText(dummyTvShow[6].original_title)))

        onView(withId(R.id.tv_release)).check(matches(isDisplayed()))
        val parser = SimpleDateFormat("yyyy-MM-dd")
        val formatter = SimpleDateFormat("dd MMMM yyyy")
        val output: String = formatter.format(parser.parse(dummyTvShow[6].release_date))
        onView(withId(R.id.tv_release)).check(matches(withText(output)))

        onView(withId(R.id.tv_popularity)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_popularity)).check(matches(withText(dummyTvShow[6].popularity.toString())))
        onView(withId(R.id.tv_rate)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_rate)).check(matches(withText(dummyTvShow[6].vote_average.toString())))

        pressBack()

    }

}