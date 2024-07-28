package com.fracta7.io.recipe

import com.fracta7.io.ensureCapacity
import com.fracta7.io.putString
import com.fracta7.model.Recipe
import java.nio.ByteBuffer
import kotlin.io.path.Path
import kotlin.io.path.writeBytes

fun writeRecipesToBinaryFile(recipes: List<Recipe>, fileName: String) {
    var buffer = ByteBuffer.allocate(256)
    buffer.putInt(recipes.size)
    recipes.forEach { recipe ->
        buffer = ensureCapacity(buffer, 256)
        buffer.putString(recipe.result)
        buffer.putInt(recipe.resultQuantity)
        buffer.putInt(recipe.requirements.size)
        recipe.requirements.forEach { (key, value) ->
            buffer = ensureCapacity(buffer, 128)
            buffer.putString(key)
            buffer.putInt(value)
        }
        buffer.putString(recipe.recipeType)
    }
    buffer.flip()
    Path(fileName).writeBytes(buffer.array().copyOf(buffer.limit()))
}
