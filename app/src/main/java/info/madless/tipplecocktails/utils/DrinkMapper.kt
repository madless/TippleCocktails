package info.madless.tipplecocktails.utils

import info.madless.tipplecocktails.models.db_entities.DrinkDb
import info.madless.tipplecocktails.models.db_entities.IngredientDb
import info.madless.tipplecocktails.models.ui_entities.Drink
import info.madless.tipplecocktails.models.ui_entities.Ingredient

/**
 * 21/2/2018.
 */

class DrinkMapper {
    companion object {
        fun map(drinkDb: DrinkDb, ingredientsDb: List<IngredientDb>): Drink {
            val ingredients = ArrayList<Ingredient>()
            ingredientsDb.mapTo(ingredients) { Ingredient(it.name, it.measure) }
            val drink = Drink()
            drink.id = drinkDb.id
            drink.name = drinkDb.name
            drink.category = drinkDb.category
            drink.alcoholType = drinkDb.alcoholType
            drink.glassType = drinkDb.glassType
            drink.instructions = drinkDb.instructions
            drink.cocktailImageUrl = drinkDb.cocktailImageUrl
            drink.ingredients = ingredients
            return drink
        }
    }
}
