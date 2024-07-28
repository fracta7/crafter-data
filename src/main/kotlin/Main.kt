package com.fracta7

import com.fracta7.data.itemsInit
import com.fracta7.data.recipeTypesInit
import com.fracta7.data.recipesInit
import com.fracta7.io.item.readItemsFromBinaryFile
import com.fracta7.io.item.writeItemsToBinaryFile
import com.fracta7.io.recipe.readRecipesFromBinaryFile
import com.fracta7.io.recipe.type.readRecipeTypesFromBinaryFile
import com.fracta7.io.recipe.type.writeRecipeTypesToBinaryFile
import com.fracta7.io.recipe.writeRecipesToBinaryFile

fun main() {
    val items = itemsInit()
    val recipes = recipesInit()
    val recipeTypes = recipeTypesInit()

    val itemsFile = "data/items.bin"
    val recipesFile = "data/recipes.bin"
    val recipeTypesFile = "data/recipe_types.bin"

    writeItemsToBinaryFile(items, itemsFile)
    writeRecipesToBinaryFile(recipes, recipesFile)
    writeRecipeTypesToBinaryFile(recipeTypes, recipeTypesFile)

    val readItems = readItemsFromBinaryFile(itemsFile)
    val readRecipes = readRecipesFromBinaryFile(recipesFile)
    val readRecipeTypes = readRecipeTypesFromBinaryFile(recipeTypesFile)

    println(readItems)
    println(readRecipes)
    println(readRecipeTypes)
}