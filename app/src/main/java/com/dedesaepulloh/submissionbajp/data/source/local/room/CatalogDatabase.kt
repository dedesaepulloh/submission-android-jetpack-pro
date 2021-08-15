package com.dedesaepulloh.submissionbajp.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dedesaepulloh.submissionbajp.data.source.local.entity.MovieEntity
import com.dedesaepulloh.submissionbajp.data.source.local.entity.TrendingEntity
import com.dedesaepulloh.submissionbajp.data.source.local.entity.TvShowEntity

@Database(
    entities = [MovieEntity::class, TvShowEntity::class, TrendingEntity::class],
    version = 3,
    exportSchema = false
)
abstract class CatalogDatabase : RoomDatabase() {
    abstract fun catalogDao(): CatalogDao
}