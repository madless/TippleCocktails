package info.madless.tipplecocktails.utils

import android.content.Context
import android.content.Intent
import info.madless.tipplecocktails.screens.cocktail_details.CocktailDetailsActivity

object IntentHelper {
    fun openCocktailDetailsScreen(context: Context) {
        val intent = Intent(context, CocktailDetailsActivity::class.java)
        context.startActivity(intent)
    }
}