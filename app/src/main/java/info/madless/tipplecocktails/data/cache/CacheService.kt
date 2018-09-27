package info.madless.tipplecocktails.data.cache

import info.madless.tipplecocktails.data.network.ApiService
import info.madless.tipplecocktails.models.server_models.DrinkShortResponse
import info.madless.tipplecocktails.models.server_models.SearchResponse
import io.reactivex.Observable

/**
 * Created by User on 16.02.2018.
 */
class CacheService: ApiService {
    override fun searchCocktailById(id: String): Observable<SearchResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun filterCocktailByAlcoholic(alcoholicType: String): Observable<DrinkShortResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun filterCocktailByCategory(category: String): Observable<DrinkShortResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}