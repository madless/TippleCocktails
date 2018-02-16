package info.madless.tipplecocktails.sections.cocktails_list.di

import dagger.Module
import dagger.Provides
import info.madless.tipplecocktails.data.ApiService
import info.madless.tipplecocktails.data.ApiServiceModule
import info.madless.tipplecocktails.sections.PerAppScope
import info.madless.tipplecocktails.sections.cocktails_list.CocktailsFragmentPresenter
import info.madless.tipplecocktails.sections.cocktails_list.abs.CocktailsFragmentView

/**
 * 16/2/2018.
 */
@Module(includes = arrayOf(ApiServiceModule::class, CocktailsFragmentViewModule::class))
class CocktailsFragmentPresenterModule {
    @Provides
    @PerAppScope
    fun providesCocktailsFragmentPresenter(cocktailsFragmentView: CocktailsFragmentView, apiService: ApiService): CocktailsFragmentPresenter {
        return CocktailsFragmentPresenter(cocktailsFragmentView, apiService)
    }
}