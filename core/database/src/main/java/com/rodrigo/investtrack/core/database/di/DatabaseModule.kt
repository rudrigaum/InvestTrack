package com.rodrigo.investtrack.core.database.di

import android.content.Context
import androidx.room.Room
import com.rodrigo.investtrack.core.database.InvestTrackDatabase
import com.rodrigo.investtrack.core.database.dao.WatchlistDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideInvestTrackDatabase(
        @ApplicationContext context: Context,
    ): InvestTrackDatabase =
        Room
            .databaseBuilder(
                context,
                InvestTrackDatabase::class.java,
                InvestTrackDatabase.DATABASE_NAME,
            ).build()

    @Provides
    @Singleton
    fun provideWatchlistDao(database: InvestTrackDatabase): WatchlistDao = database.watchlistDao()
}
