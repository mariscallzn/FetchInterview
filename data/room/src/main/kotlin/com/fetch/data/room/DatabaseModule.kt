package com.fetch.data.room

import android.content.Context
import androidx.room.Room
import com.fetch.data.room.dao.HiringItemDao
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
    fun providesDatabase(
        @ApplicationContext context: Context
    ): FetchDatabase = Room.databaseBuilder(
        context = context,
        klass = FetchDatabase::class.java,
        name = "fetch-database"
    ).build()

    @Provides
    @Singleton
    fun providesHiringItemsDao(db: FetchDatabase): HiringItemDao = db.hiringItemDao()
}