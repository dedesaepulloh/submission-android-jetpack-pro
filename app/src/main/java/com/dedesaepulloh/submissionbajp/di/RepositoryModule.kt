package com.dedesaepulloh.submissionbajp.di

import com.dedesaepulloh.submissionbajp.data.source.CatalogDataSource
import com.dedesaepulloh.submissionbajp.data.source.CatalogRepository
import dagger.Binds
import dagger.Module

@Module(includes = [DatabaseModule::class])
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(catalogRepository: CatalogRepository): CatalogDataSource
}