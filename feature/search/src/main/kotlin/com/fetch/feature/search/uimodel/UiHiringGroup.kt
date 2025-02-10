package com.fetch.feature.search.uimodel

data class UiHiringGroup(val groupId: Int, val items: List<UiHiringItem>)

data class UiHiringItem(val id: Int, val name: String)