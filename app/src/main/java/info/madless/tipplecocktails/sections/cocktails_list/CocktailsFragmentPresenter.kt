package info.madless.tipplecocktails.sections.cocktails_list

import info.madless.tipplecocktails.TippleCocktailsApp
import info.madless.tipplecocktails.data.Repository
import info.madless.tipplecocktails.models.db_entities.DrinkDb
import info.madless.tipplecocktails.models.db_entities.IngredientDb
import info.madless.tipplecocktails.models.ui_entities.Drink
import info.madless.tipplecocktails.sections.AppScope
import info.madless.tipplecocktails.sections.abs.BasePresenter
import info.madless.tipplecocktails.sections.cocktails_list.abs.CocktailsFragmentView
import info.madless.tipplecocktails.utils.DrinkMapper
import info.madless.tipplecocktails.utils.MockHelper

/**
 * 16/2/2018.
 */
@AppScope
class CocktailsFragmentPresenter(): BasePresenter() {

    lateinit var cocktailsFragmentView: CocktailsFragmentView
    lateinit var repository: Repository

    constructor(cocktailsFragmentView: CocktailsFragmentView, repository: Repository) : this() {
        this.cocktailsFragmentView = cocktailsFragmentView
        this.repository = repository
        logger.d("Constructor presenter: ${this.hashCode()}")
    }

    fun execute() {
        logger.d("Execute in presenter: ${this.hashCode()}")
        var drinks = MockHelper.getAllDrinks(TippleCocktailsApp.appContext)
        fillDb(drinks)
        checkDb()
    }

    fun fillDb(drinks: List<Drink>) {
        for (drink in drinks) {

            val drinkDb = DrinkDb(drink.id, drink.name, drink.category, drink.alcoholType, drink.glassType, drink.instructions, drink.cocktailImageUrl)
            repository.insertDrink(drinkDb)

            drink.ingredients?.let {
                for (i in it) {
                    val ingredientDb = IngredientDb(drink.id, i.name, i.measure)
                    repository.insertIngredient(ingredientDb)
                }
            }

        }
        logger.d("Db filled!")
    }

    fun checkDb() {
        logger.d("checkDb")
        val drinksDb = repository.getAllDrinks()
        val drinks = ArrayList<Drink>()
        for (drink in drinksDb) {
            val ingredients = repository.getIngredientsByDrink(drink.id)
            drinks.add(DrinkMapper.map(drink, ingredients))
        }
        drinks.forEach { drink ->
            logger.d("Drink: ${drink.name}")
        }
    }
}
