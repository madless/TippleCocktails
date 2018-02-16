package info.madless.tipplecocktails.sections.cocktails_list

import info.madless.tipplecocktails.data.ApiService
import info.madless.tipplecocktails.sections.abs.BasePresenter
import info.madless.tipplecocktails.sections.cocktails_list.abs.CocktailsFragmentView
import info.madless.tipplecocktails.server_models.SearchResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

/**
 * 16/2/2018.
 */
@Singleton
class CocktailsFragmentPresenter(): BasePresenter() {

    lateinit var cocktailsFragmentView: CocktailsFragmentView
    lateinit var apiService: ApiService

    constructor(cocktailsFragmentView: CocktailsFragmentView, apiService: ApiService) : this() {
        this.cocktailsFragmentView = cocktailsFragmentView
        this.apiService = apiService
        logger.d("Constructor presenter: ${this.hashCode()}")
    }

    fun execute() {
        logger.d("Execute in presenter: ${this.hashCode()}")
        apiService.searchCocktailByName("margarita")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({
                    searchResponse: SearchResponse ->
                    logger.d("Response: ${searchResponse.drinks[0].name}")
                },
                {
                    t: Throwable? -> t?.printStackTrace()
                })
    }
}
