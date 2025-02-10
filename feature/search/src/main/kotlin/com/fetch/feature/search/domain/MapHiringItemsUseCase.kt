package com.fetch.feature.search.domain

import com.fetch.core.model.HiringItem
import com.fetch.feature.search.uimodel.UiHiringGroup
import com.fetch.feature.search.uimodel.UiHiringItem
import javax.inject.Inject

/**
 * Use case that applies the following business requirements
 *
 * - Display all the items grouped by "listId"
 * - Sort the results first by "listId" then by "name" when displaying.
 * - Filter out any items where "name" is blank or null.
 */
class MapHiringItemsUseCase @Inject constructor() {
    operator fun invoke(items: List<HiringItem>): List<UiHiringGroup> {
        return items.filterNot { it.name.isNullOrBlank() }
            .groupBy { it.listId }.map { map ->
                UiHiringGroup(
                    groupId = map.key ?: 0,
                    items = map.value.sortedWith(compareBy {
                        val match = "\\d+".toRegex().find(
                            it.name?.lowercase() ?: ""
                        )
                        match?.value?.toInt() ?: Int.MAX_VALUE
                    }).map { UiHiringItem(id = it.id ?: 0, name = it.name ?: "") }
                )
            }.sortedBy { it.groupId }
    }
}