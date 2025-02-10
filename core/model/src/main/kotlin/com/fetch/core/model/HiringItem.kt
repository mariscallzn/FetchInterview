package com.fetch.core.model

import kotlinx.serialization.Serializable

/**
 * Base model for [HiringItem] used in composable
 *
 * Uses [Serializable] annotation
 */
@Serializable
data class HiringItem(
    val id: Int?,
    val listId: Int?,
    val name: String?
)