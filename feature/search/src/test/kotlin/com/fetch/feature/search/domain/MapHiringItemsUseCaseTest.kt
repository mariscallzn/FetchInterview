package com.fetch.feature.search.domain

import com.fetch.core.model.HiringItem
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class MapHiringItemsUseCaseTest {

    private lateinit var useCase: MapHiringItemsUseCase

    @Before
    fun setup() {
        useCase = MapHiringItemsUseCase()
    }

    @Test
    fun `validate items are grouped by list id`() {
        val list = mutableListOf<HiringItem>()
        for (i in 1..300) {
            list.add(HiringItem(id = i, name = if (i % 2 == 0) null else "Item $i", listId = i))
        }
        val copy = listOf(*list.toTypedArray())
        list.shuffle()
        val result = useCase(list)
        assertTrue(result.map { it.groupId } == copy.filterNot { it.name.isNullOrBlank() }.map { it.listId })
    }
}