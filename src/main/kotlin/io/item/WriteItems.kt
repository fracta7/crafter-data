package com.fracta7.io.item

import com.fracta7.io.ensureCapacity
import com.fracta7.io.putBoolean
import com.fracta7.io.putString
import com.fracta7.model.Item
import java.nio.ByteBuffer
import kotlin.io.path.Path
import kotlin.io.path.writeBytes

fun writeItemsToBinaryFile(items: List<Item>, fileName: String) {
    var buffer = ByteBuffer.allocate(256)
    buffer.putInt(items.size)
    items.forEach { item ->
        buffer = ensureCapacity(buffer, 256)
        buffer.putString(item.id)
        buffer.putString(item.name)
        buffer.putInt(item.stackSize)
        buffer.putBoolean(item.craftable)
    }
    buffer.flip()
    Path(fileName).writeBytes(buffer.array().copyOf(buffer.limit()))
}

