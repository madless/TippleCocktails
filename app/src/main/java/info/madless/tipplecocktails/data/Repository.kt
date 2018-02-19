package info.madless.tipplecocktails.data

import info.madless.tipplecocktails.server_models.DrinkShortResponse
import info.madless.tipplecocktails.server_models.IngredientFullResponse
import info.madless.tipplecocktails.server_models.SearchResponse
import io.reactivex.Observable

/**
 * 15/2/2018.
 */
class Repository(val apiService: ApiService, val cacheService: CacheService): ApiService {
    override fun searchCocktailByName(cocktailName: String): Observable<SearchResponse> {
        return apiService.searchCocktailByName(cocktailName)
    }

    override fun searchCocktailById(id: String): Observable<SearchResponse> {
        return apiService.searchCocktailById(id)
    }

    override fun searchIngredientByName(ingredientName: String): Observable<IngredientFullResponse> {
        return apiService.searchIngredientByName(ingredientName)
    }

    override fun filterCocktailByAlcoholic(alcoholicType: String): Observable<DrinkShortResponse> {
        return apiService.filterCocktailByAlcoholic(alcoholicType)
    }

    override fun filterCocktailByIngredient(ingredientName: String): Observable<DrinkShortResponse> {
        return apiService.filterCocktailByIngredient(ingredientName)
    }

    override fun filterCocktailByCategory(category: String): Observable<DrinkShortResponse> {
        return apiService.filterCocktailByCategory(category)
    }
}