package com.fracta7.io

import java.nio.ByteBuffer

fun ByteBuffer.putString(value: String): ByteBuffer {
    val bytes = value.toByteArray(Charsets.UTF_8)
    putInt(bytes.size)
    put(bytes)
    return this
}

fun ByteBuffer.getString(): String {
    val size = int
    val bytes = ByteArray(size)
    get(bytes)
    return String(bytes, Charsets.UTF_8)
}

fun ByteBuffer.putBoolean(value: Boolean): ByteBuffer {
    put(if (value) 1 else 0)
    return this
}

fun ByteBuffer.getBoolean(): Boolean {
    return get().toInt() != 0
}

fun ensureCapacity(buffer: ByteBuffer, additionalCapacity: Int): ByteBuffer {
    if (buffer.remaining() < additionalCapacity) {
        val newCapacity = buffer.capacity() * 2 + additionalCapacity
        val newBuffer = ByteBuffer.allocate(newCapacity)
        buffer.flip()
        newBuffer.put(buffer)
        return newBuffer
    }
    return buffer
}
