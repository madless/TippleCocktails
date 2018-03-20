package info.madless.tipplecocktails.utils

import android.content.Context
import com.google.gson.Gson
import info.madless.tipplecocktails.models.ui_entities.Drink
import info.madless.tipplecocktails.models.ui_entities.Drinks
import info.madless.tipplecocktails.models.ui_entities.Ingredient
import info.madless.tipplecocktails.models.ui_entities.Ingredients
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * 20/2/2018.
 */
class MockHelper {
    companion object {
        fun getAllDrinks(context: Context): List<Drink> {
            try {
                val logger: Logger = Logger(MockHelper::class.java)
                val buf = StringBuilder()
                val json = context.assets.open("drinksFormatted.json")
                val input = BufferedReader(InputStreamReader(json, "UTF-8"))
                var str: String? = input.readLine()
                while (str != null) {
                    buf.append(str)
                    str = input.readLine()
                }
                input.close()
                val drinksJson = buf.toString()
                val drinksObj: Drinks = Gson().fromJson(drinksJson, Drinks::class.java)
                return drinksObj.drinks.subList(0, drinksObj.drinks.size - 1)
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return ArrayList()
        }

        fun getAllIngredientsInfo(context: Context): List<Ingredient> {
            try {
                val logger: Logger = Logger(MockHelper::class.java)
                val buf = StringBuilder()
                val json = context.assets.open("ingredientsFormatted.json")
                val input = BufferedReader(InputStreamReader(json, "UTF-8"))
                var str: String? = input.readLine()
                while (str != null) {
                    buf.append(str)
                    str = input.readLine()
                }
                input.close()
                val ingredientsJson = buf.toString()
                val ingredientsObj: Ingredients = Gson().fromJson(ingredientsJson, Ingredients::class.java)
                return ingredientsObj.ingredients
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return ArrayList()
        }
    }
}