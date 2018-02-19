package info.madless.tipplecocktails.data

import info.madless.tipplecocktails.server_models.DrinkShortResponse
import info.madless.tipplecocktails.server_models.IngredientFullResponse
import info.madless.tipplecocktails.server_models.SearchResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * 15/2/2018.
 */
interface ApiService {
    @GET("search.php")
    fun searchCocktailByName(@Query("s") cocktailName: String): Observable<SearchResponse>

    @GET("lookup.php")
    fun searchCocktailById(@Query("i") id: String): Observable<SearchResponse>

    @GET("search.php")
    fun searchIngredientByName(@Query("i") ingredientName: String): Observable<IngredientFullResponse>

    @GET("filter.php")
    fun filterCocktailByAlcoholic(@Query("a") alcoholicType: String): Observable<DrinkShortResponse>

    @GET("filter.php")
    fun filterCocktailByIngredient(@Query("i") ingredientName: String): Observable<DrinkShortResponse>

    @GET("filter.phh")
    fun filterCocktailByCategory(@Query("c") category: String): Observable<DrinkShortResponse>
}