package com.fracta7.io.recipe.type

import com.fracta7.io.ensureCapacity
import com.fracta7.io.putString
import com.fracta7.model.RecipeType
import java.nio.ByteBuffer
import kotlin.io.path.Path
import kotlin.io.path.writeBytes

fun writeRecipeTypesToBinaryFile(recipeTypes: List<RecipeType>, fileName: String) {
    var buffer = ByteBuffer.allocate(256)
    buffer.putInt(recipeTypes.size)
    recipeTypes.forEach { recipeType ->
        buffer = ensureCapacity(buffer, 128)
        buffer.putString(recipeType.id)
        buffer.putString(recipeType.name)
        buffer.putString(recipeType.item)
    }
    buffer.flip()
    Path(fileName).writeBytes(buffer.array().copyOf(buffer.limit()))
}
