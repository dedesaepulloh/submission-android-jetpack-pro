package com.dedesaepulloh.submissionbajp

import android.app.Application
import com.dedesaepulloh.submissionbajp.di.AppComponent
import com.dedesaepulloh.submissionbajp.di.DaggerAppComponent

open class BaseApplication : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}