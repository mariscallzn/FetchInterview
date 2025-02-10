package com.fetch.data.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.fetch.data.room.entity.HiringItemEntity

@Dao
interface HiringItemDao : BaseDao<HiringItemEntity> {

    @Query("""
        SELECT * FROM hiring_items
    """)
    suspend fun fetchAll(): List<HiringItemEntity>

    @Query("""
        DELETE FROM hiring_items
    """)
    suspend fun clearTable()
}