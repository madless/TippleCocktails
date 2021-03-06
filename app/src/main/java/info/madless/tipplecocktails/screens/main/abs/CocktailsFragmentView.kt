package info.madless.tipplecocktails.screens.main.abs

import info.madless.tipplecocktails.models.ui_entities.Drink

/**
 * 16/2/2018.
 */
interface CocktailsFragmentView {
    fun onLoadingStarted()
    fun onLoadingFinished()
    fun onDrinksFetched(alcoholicDrinks: ArrayList<Drink>, nonAlcoholicDrinks: ArrayList<Drink>, optionalDrinks: ArrayList<Drink>)
}