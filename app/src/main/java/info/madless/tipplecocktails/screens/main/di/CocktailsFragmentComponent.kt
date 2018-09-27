package info.madless.tipplecocktails.screens.main.di

import dagger.Component
import info.madless.tipplecocktails.AppScope
import info.madless.tipplecocktails.screens.main.CocktailsFragmentPresenter

/**
 * 16/2/2018.
 */
@AppScope
@Component(modules = arrayOf(CocktailsFragmentViewModule::class, CocktailsFragmentPresenterModule::class))
interface CocktailsFragmentComponent {
    fun getCocktailsFragmentPresenter(): CocktailsFragmentPresenter
}