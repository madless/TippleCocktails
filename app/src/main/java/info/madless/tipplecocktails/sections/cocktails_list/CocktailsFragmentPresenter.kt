package info.madless.tipplecocktails.sections.cocktails_list

import info.madless.tipplecocktails.data.Repository
import info.madless.tipplecocktails.sections.AppScope
import info.madless.tipplecocktails.sections.abs.BasePresenter
import info.madless.tipplecocktails.sections.cocktails_list.abs.CocktailsFragmentView
import info.madless.tipplecocktails.server_models.SearchResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

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
        repository.searchCocktailByName("margarita")
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
