package com.rodrigo.investtrack.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rodrigo.investtrack.core.database.dao.WatchlistDao
import com.rodrigo.investtrack.core.database.entity.WatchlistEntity

@Database(
    entities = [WatchlistEntity::class],
    version = 1,
    exportSchema = true,
)
abstract class InvestTrackDatabase : RoomDatabase() {
    abstract fun watchlistDao(): WatchlistDao

    companion object {
        const val DATABASE_NAME = "investtrack.db"
    }
}
