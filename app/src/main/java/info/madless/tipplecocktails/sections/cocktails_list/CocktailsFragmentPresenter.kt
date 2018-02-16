package info.madless.tipplecocktails.sections.cocktails_list

import android.util.Log
import info.madless.tipplecocktails.data.ApiService
import info.madless.tipplecocktails.sections.PerActivity
import info.madless.tipplecocktails.sections.cocktails_list.abs.CocktailsFragmentView
import info.madless.tipplecocktails.server_models.SearchResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * 16/2/2018.
 */

@PerActivity
class CocktailsFragmentPresenter @Inject constructor(private val cocktailsFragmentView: CocktailsFragmentView,
                                                     private val apiService: ApiService) {
    fun execute() {
        apiService.searchCocktailByName("margarita")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({
                    searchResponse: SearchResponse ->
                    Log.d("madless", "Response: $searchResponse")
                },
                {
                    t: Throwable? -> t?.printStackTrace()
                })
    }
}
