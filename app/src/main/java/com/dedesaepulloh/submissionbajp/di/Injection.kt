package com.dedesaepulloh.submissionbajp.di

import com.dedesaepulloh.submissionbajp.data.source.CatalogRepository
import com.dedesaepulloh.submissionbajp.data.source.remote.RemoteDataSource

object Injection {
    fun provideCatalogRepository(): CatalogRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return CatalogRepository.getInstance(remoteDataSource)
    }
}