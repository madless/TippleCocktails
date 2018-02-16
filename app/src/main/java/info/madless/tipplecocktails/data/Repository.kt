package info.madless.tipplecocktails.data

import info.madless.tipplecocktails.server_models.DrinkShortResponse
import info.madless.tipplecocktails.server_models.SearchResponse
import io.reactivex.Observable

/**
 * 15/2/2018.
 */
class Repository(val apiService: ApiService) {
    fun searchCocktailByName(name: String): Observable<SearchResponse> {
        return apiService.searchCocktailByName(name)
    }

    fun searchCocktailById(id: String): Observable<SearchResponse> {
        return apiService.searchCocktailById(id)
    }

    fun filterCocktailByAlcoholic(alcoholicType: String): Observable<DrinkShortResponse> {
        return apiService.filterCocktailByAlcoholic(alcoholicType)
    }
}