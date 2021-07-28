package com.dedesaepulloh.submissionbajp.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dedesaepulloh.submissionbajp.databinding.ActivitySplashScreenBinding
import com.dedesaepulloh.submissionbajp.ui.home.HomeActivity
import com.dedesaepulloh.submissionbajp.utils.Helper.TIME_MILLIS
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashScreenActivity : AppCompatActivity() {

    private lateinit var screenBinding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        screenBinding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(screenBinding.root)

        CoroutineScope(Dispatchers.Main).launch {
            delay(TIME_MILLIS)
            startActivity(Intent(this@SplashScreenActivity, HomeActivity::class.java))
            finish()
        }

    }
}