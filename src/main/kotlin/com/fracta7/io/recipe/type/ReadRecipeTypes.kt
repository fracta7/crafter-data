package com.fracta7.io.recipe.type

import com.fracta7.io.getString
import com.fracta7.model.RecipeType
import java.nio.ByteBuffer
import kotlin.io.path.Path
import kotlin.io.path.readBytes

fun readRecipeTypesFromBinaryFile(fileName: String): List<RecipeType> {
    val bytes = Path(fileName).readBytes()
    val buffer = ByteBuffer.wrap(bytes)
    val recipeTypesSize = buffer.int
    val recipeTypes = mutableListOf<RecipeType>()
    repeat(recipeTypesSize) {
        val id = buffer.getString()
        val name = buffer.getString()
        val item = buffer.getString()
        recipeTypes.add(RecipeType(id, name, item))
    }
    return recipeTypes
}
