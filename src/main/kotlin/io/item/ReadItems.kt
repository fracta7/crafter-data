package com.fracta7.io.item

import com.fracta7.io.getBoolean
import com.fracta7.io.getString
import com.fracta7.model.Item
import java.nio.ByteBuffer
import kotlin.io.path.Path
import kotlin.io.path.readBytes

fun readItemsFromBinaryFile(fileName: String): List<Item> {
    val bytes = Path(fileName).readBytes()
    val buffer = ByteBuffer.wrap(bytes)
    val itemsSize = buffer.int
    val items = mutableListOf<Item>()
    repeat(itemsSize) {
        val id = buffer.getString()
        val name = buffer.getString()
        val stackSize = buffer.int
        val craftable = buffer.getBoolean()
        items.add(Item(id, name, stackSize, craftable))
    }
    return items
}

