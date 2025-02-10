package com.fetch.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fetch.data.room.dao.HiringItemDao
import com.fetch.data.room.entity.HiringItemEntity

@Database(
    entities = [
        HiringItemEntity::class,
    ], version = 1
)
abstract class FetchDatabase : RoomDatabase(){
    abstract fun hiringItemDao(): HiringItemDao
}