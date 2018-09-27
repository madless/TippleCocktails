package info.madless.tipplecocktails.screens.main.di

import dagger.Module
import dagger.Provides
import info.madless.tipplecocktails.data.Repository
import info.madless.tipplecocktails.AppScope
import info.madless.tipplecocktails.screens.main.CocktailsFragmentPresenter
import info.madless.tipplecocktails.screens.main.abs.CocktailsFragmentView

/**
 * 16/2/2018.
 */
@Module(includes = arrayOf(CocktailsFragmentViewModule::class))
class CocktailsFragmentPresenterModule(private var repository: Repository) {
    @Provides
    @AppScope
    fun providesCocktailsFragmentPresenter(cocktailsFragmentView: CocktailsFragmentView): CocktailsFragmentPresenter {
        return CocktailsFragmentPresenter(cocktailsFragmentView, repository)
    }
}