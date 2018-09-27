package info.madless.tipplecocktails.screens.main

import info.madless.tipplecocktails.TippleCocktailsApp
import info.madless.tipplecocktails.data.Repository
import info.madless.tipplecocktails.models.db_entities.DrinkDb
import info.madless.tipplecocktails.models.db_entities.IngredientDb
import info.madless.tipplecocktails.models.ui_entities.Drink
import info.madless.tipplecocktails.AppScope
import info.madless.tipplecocktails.screens.abs.BasePresenter
import info.madless.tipplecocktails.screens.main.abs.CocktailsFragmentView
import info.madless.tipplecocktails.utils.Const
import info.madless.tipplecocktails.utils.DrinkMapper
import info.madless.tipplecocktails.utils.MockHelper
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * 16/2/2018.
 */
@AppScope
class CocktailsFragmentPresenter() : BasePresenter() {

    lateinit var cocktailsFragmentView: CocktailsFragmentView
    lateinit var repository: Repository

    constructor(cocktailsFragmentView: CocktailsFragmentView, repository: Repository) : this() {
        this.cocktailsFragmentView = cocktailsFragmentView
        this.repository = repository
        logger.d("Constructor presenter: ${this.hashCode()}")
    }

    fun execute() {
        logger.d("Execute in presenter: ${this.hashCode()}")
        if (repository.isDbFilled) {
            cocktailsFragmentView.onLoadingStarted()
            val alcoholicDrinksDb = repository.getDrinksByAlcoholicType(Const.TYPE_ALCOHOLIC)
            val nonAlcoholicDrinksDb = repository.getDrinksByAlcoholicType(Const.TYPE_NON_ALCOHOLIC)
            val optionalAlcoholicDrinksDb = repository.getDrinksByAlcoholicType(Const.TYPE_OPTIONAL_ALCOHOLIC)
            cocktailsFragmentView.onDrinksFetched(mapDrinks(alcoholicDrinksDb), mapDrinks(nonAlcoholicDrinksDb), mapDrinks(optionalAlcoholicDrinksDb))
            cocktailsFragmentView.onLoadingFinished()
        } else {
            fillDb()
        }
    }

    fun fillDb() {
        logger.d("Try get json...")
        val drinks = MockHelper.getAllDrinks(TippleCocktailsApp.appContext)
        val fillDbObservable = Observable.create { emitter: ObservableEmitter<Any>? ->
            logger.d("Started db filling...")
            for (drink in drinks) {
                val url = if (drink.cocktailImageUrl?.contains("http://|https://") == true) {
                    drink.cocktailImageUrl
                } else {
                    "http://${drink.cocktailImageUrl}"
                }
                val drinkDb = DrinkDb(drink.id, drink.name, drink.category, drink.alcoholType, drink.glassType, drink.instructions, url)
                repository.insertDrink(drinkDb)
                drink.ingredients?.let {
                    for (i in it) {
                        val ingredientDb = IngredientDb(drink.id, i.name, i.measure)
                        repository.insertIngredient(ingredientDb)
                    }
                }
            }
            logger.d("Db filled!")
            emitter?.onNext(Any())
            emitter?.onComplete()
        }.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread())
        cocktailsFragmentView.onLoadingStarted()
        logger.d("Try fill db...")
        fillDbObservable.subscribe({ result: Any? ->
            val alcoholicDrinksDb = repository.getDrinksByAlcoholicType(Const.TYPE_ALCOHOLIC)
            val nonAlcoholicDrinksDb = repository.getDrinksByAlcoholicType(Const.TYPE_NON_ALCOHOLIC)
            val optionalAlcoholicDrinksDb = repository.getDrinksByAlcoholicType(Const.TYPE_OPTIONAL_ALCOHOLIC)
            cocktailsFragmentView.onDrinksFetched(mapDrinks(alcoholicDrinksDb), mapDrinks(nonAlcoholicDrinksDb), mapDrinks(optionalAlcoholicDrinksDb))
            cocktailsFragmentView.onLoadingFinished()
        }, { error -> error.printStackTrace() })

    }

    private fun mapDrinks(drinksDb: List<DrinkDb>): ArrayList<Drink> {
        val drinks = ArrayList<Drink>()
        for (drink in drinksDb) {
            val ingredients = repository.getIngredientsByDrink(drink.id)
            drinks.add(DrinkMapper.map(drink, ingredients))
        }
        return drinks
    }
}
