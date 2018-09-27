package info.madless.tipplecocktails.data

import info.madless.tipplecocktails.data.cache.CacheService
import info.madless.tipplecocktails.data.db.DbService
import info.madless.tipplecocktails.data.db.dao.DrinkDao
import info.madless.tipplecocktails.data.db.dao.IngredientDao
import info.madless.tipplecocktails.data.network.ApiService
import info.madless.tipplecocktails.models.db_entities.DrinkDb
import info.madless.tipplecocktails.models.db_entities.IngredientDb
import info.madless.tipplecocktails.server_models.DrinkShortResponse
import info.madless.tipplecocktails.server_models.SearchResponse
import io.reactivex.Observable

/**
 * 15/2/2018.
 */
class Repository(private val apiService: ApiService, private val cacheService: CacheService, private val dbService: DbService): ApiService, DrinkDao, IngredientDao {

    var isDbFilled = false
        get()= dbService.getDrinkDao().getAllDrinks().isNotEmpty()

    override fun searchCocktailById(id: String): Observable<SearchResponse> {
        return apiService.searchCocktailById(id)
    }

    override fun filterCocktailByAlcoholic(alcoholicType: String): Observable<DrinkShortResponse> {
        return apiService.filterCocktailByAlcoholic(alcoholicType)
    }

    override fun filterCocktailByCategory(category: String): Observable<DrinkShortResponse> {
        return apiService.filterCocktailByCategory(category)
    }

    override fun getAllDrinks(): List<DrinkDb> {
        return dbService.getDrinkDao().getAllDrinks()
    }

    override fun getAllIngredients(): List<IngredientDb> {
        return dbService.getIngredientDao().getAllIngredients()
    }

    override fun insertDrink(drinkDb: DrinkDb) {
        dbService.getDrinkDao().insertDrink(drinkDb)
    }

    override fun getIngredientsByDrink(drinkId: String): List<IngredientDb> {
        return dbService.getIngredientDao().getIngredientsByDrink(drinkId)
    }

    override fun deleteAllDrinks() {
        dbService.getDrinkDao().deleteAllDrinks()
    }

    override fun insertIngredient(ingredientDb: IngredientDb) {
        dbService.getIngredientDao().insertIngredient(ingredientDb)
    }

    override fun deleteAllIngredients() {
        dbService.getIngredientDao().deleteAllIngredients()
    }

    override fun getDrinksByAlcoholicType(alcoholType: String): List<DrinkDb> {
        return dbService.getDrinkDao().getDrinksByAlcoholicType(alcoholType)
    }
}