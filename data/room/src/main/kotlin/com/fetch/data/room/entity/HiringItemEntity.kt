package com.fetch.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fetch.core.model.HiringItem

@Entity(
    tableName = "hiring_items"
)
data class HiringItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "cloud_id")
    val cloudId: Int?,
    @ColumnInfo(name = "list_id")
    val listId: Int?,
    val name: String?
)

fun HiringItemEntity.toHiringItem() = HiringItem(
    id = cloudId,
    listId = listId,
    name = name,
)

fun HiringItem.toHiringItemEntity() = HiringItemEntity(
    cloudId = id,
    listId = listId,
    name = name,
)