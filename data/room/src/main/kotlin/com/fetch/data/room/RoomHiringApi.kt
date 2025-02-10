package com.fetch.data.room

import com.fetch.core.model.HiringItem
import com.fetch.data.api.HiringApi
import com.fetch.data.room.dao.HiringItemDao
import com.fetch.data.room.entity.toHiringItem
import com.fetch.data.room.entity.toHiringItemEntity
import javax.inject.Inject

/**
 * Room implementation of [HiringApi] to enable offline support
 */
class RoomHiringApi @Inject constructor(
    private val hiringItemDao: HiringItemDao,
) : HiringApi {

    /**
     * Fetch all hiring items
     *
     * @return List of [HiringItem] wrapped on a [Result]
     */
    override suspend fun fetch(): Result<List<HiringItem>> = Result.runCatching {
        hiringItemDao.fetchAll().map { it.toHiringItem() }
    }

    /**
     * Pretty basic implementation for syncing cloud and local
     *
     * @param items list to be be inserted
     */
    override suspend fun insertAll(items: List<HiringItem>): Result<Unit> = Result.runCatching {
        hiringItemDao.clearTable()
        hiringItemDao.insertAll(items.map { it.toHiringItemEntity() })
    }

}