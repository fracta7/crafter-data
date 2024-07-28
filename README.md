# Command-line utility for Crafter

# Usage

Download the latest release and run using command-line. Java version shouldn't matter much, Java 8+ should do (*untested*): 

```
java -jar crafter-data.jar
```

# Building

It is recommended to use **Gradle** for building the project. For building:

```
gradle build
```

# Developing

Utility simply stores items as `List<Item>` in a function - `itemsInit(): List<Item>` which is in `com.fracta7.data.ItemsInit.kt`. Recipes are stored in the same package `recipesInit(): List<Recipe>`. Recipe types are stored in `recipeTypesInit(): List<RecipeType>`. In the main function, items, recipes and recipe types are stored in a variable and simply passed to writing functions, which simply write to `data/*.bin` files corresponding to each file. Adding new recipes and items can be done in `itemsInit()`, `recipesInit()` and `recipeTypesInit()` functions. Item icons are store in `data/items` folder and each item icon corresponds to their `ItemID` specified in `itemsInit()` function.

Data classes are prototyped in the following way:

`Item.kt`:

```kotlin
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
```

`Recipe.kt`:

```kotlin
typealias ItemID = String
typealias RecipeID = String

/**
 * Data class to represent recipes
 * @property result result of recipe
 * @property resultQuantity quantity of resulting item
 * @property requirements a map of required items mapped to their quantity.
 * @property recipeType defines the recipe type (crafting, smelting etc.).
 */
data class Recipe(
    val result: ItemID,
    val resultQuantity: Int,
    val requirements: Map<ItemID, Int>,
    val recipeType: RecipeID
)
```

`RecipeType.kt`:

```kotlin
/**
 * data class to represent different recipe types.
 * @property id represents the ID of recipe.
 * @property name represents the name of recipe.
 * @property item is the itemID of recipe representation
 */
data class RecipeType(
    val id: RecipeID,
    val name: String,
    val item: ItemID
)
```
