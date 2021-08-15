package com.dedesaepulloh.submissionbajp.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.dedesaepulloh.submissionbajp.R
import com.dedesaepulloh.submissionbajp.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    private lateinit var activityHomeBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)

        val bottomNavigationView: BottomNavigationView = activityHomeBinding.bottomNav
        val navController = findNavController(R.id.nav_fragment)
        val appBarConfiguration =
            AppBarConfiguration(setOf(R.id.trending_nav, R.id.movie_nav, R.id.tvshow_nav, R.id.favorite_nav))

        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomNavigationView.setupWithNavController(navController)
    }
}