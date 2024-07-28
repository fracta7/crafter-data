package com.fracta7.model

/**
 * Minecraft Item.
 * @property id string id of an item.
 * @property name name of an item.
 * @property stackSize stack size of an item.
 * @property craftable indicates if it is craftable.
 */
data class Item(
    val id: ItemID,
    val name: String,
    val stackSize: Int,
    val craftable: Boolean
)