package info.madless.tipplecocktails.screens.main.abs

import info.madless.tipplecocktails.models.ui_entities.Drink

interface OnCocktailClickedListener {
    fun onCocktailClicked(drink: Drink)
}