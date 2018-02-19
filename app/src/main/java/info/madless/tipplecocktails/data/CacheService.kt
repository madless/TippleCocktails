package info.madless.tipplecocktails.data

import info.madless.tipplecocktails.server_models.DrinkShortResponse
import info.madless.tipplecocktails.server_models.IngredientFullResponse
import info.madless.tipplecocktails.server_models.SearchResponse
import io.reactivex.Observable

/**
 * Created by User on 16.02.2018.
 */
class CacheService(): ApiService {
    override fun searchCocktailByName(cocktailName: String): Observable<SearchResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun searchCocktailById(id: String): Observable<SearchResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun searchIngredientByName(ingredientName: String): Observable<IngredientFullResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun filterCocktailByAlcoholic(alcoholicType: String): Observable<DrinkShortResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun filterCocktailByIngredient(ingredientName: String): Observable<DrinkShortResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun filterCocktailByCategory(category: String): Observable<DrinkShortResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}