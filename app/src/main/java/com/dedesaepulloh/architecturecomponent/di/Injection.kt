package com.dedesaepulloh.architecturecomponent.di

import com.dedesaepulloh.architecturecomponent.data.source.CatalogRepository
import com.dedesaepulloh.architecturecomponent.data.source.remote.RemoteDataSource

object Injection {
    fun provideCatalogRepository(): CatalogRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return CatalogRepository.getInstance(remoteDataSource)
    }
}