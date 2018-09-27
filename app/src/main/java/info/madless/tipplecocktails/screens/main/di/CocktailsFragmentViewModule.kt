package info.madless.tipplecocktails.screens.main.di

import dagger.Module
import dagger.Provides
import info.madless.tipplecocktails.screens.main.abs.CocktailsFragmentView

/**
 * 16/2/2018.
 */
@Module
class CocktailsFragmentViewModule(private val cocktailsFragmentView: CocktailsFragmentView) {
    @Provides
    fun providesCocktailsFragmentView(): CocktailsFragmentView = cocktailsFragmentView
}