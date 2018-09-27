package info.madless.tipplecocktails.data.network

import info.madless.tipplecocktails.models.server_models.DrinkShortResponse
import info.madless.tipplecocktails.models.server_models.SearchResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * 15/2/2018.
 */
interface ApiService {
    @GET("lookup.php")
    fun searchCocktailById(@Query("i") id: String): Observable<SearchResponse>

    @GET("filter.php")
    fun filterCocktailByAlcoholic(@Query("a") alcoholicType: String): Observable<DrinkShortResponse>

    @GET("filter.phh")
    fun filterCocktailByCategory(@Query("c") category: String): Observable<DrinkShortResponse>
}