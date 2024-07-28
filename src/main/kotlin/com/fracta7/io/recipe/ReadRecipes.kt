package com.fracta7.io.recipe

import com.fracta7.io.getString
import com.fracta7.model.Recipe
import java.nio.ByteBuffer
import kotlin.io.path.Path
import kotlin.io.path.readBytes

fun readRecipesFromBinaryFile(fileName: String): List<Recipe> {
    val bytes = Path(fileName).readBytes()
    val buffer = ByteBuffer.wrap(bytes)
    val recipesSize = buffer.int
    val recipes = mutableListOf<Recipe>()
    repeat(recipesSize) {
        val result = buffer.getString()
        val resultQuantity = buffer.int
        val requirementsSize = buffer.int
        val requirements = mutableMapOf<String, Int>()
        repeat(requirementsSize) {
            val key = buffer.getString()
            val value = buffer.int
            requirements[key] = value
        }
        val recipeType = buffer.getString()
        recipes.add(Recipe(result, resultQuantity, requirements, recipeType))
    }
    return recipes
}
