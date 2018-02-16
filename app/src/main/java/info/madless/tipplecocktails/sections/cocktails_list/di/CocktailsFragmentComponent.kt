package info.madless.tipplecocktails.sections.cocktails_list.di

import dagger.Component
import info.madless.tipplecocktails.sections.PerAppScope
import info.madless.tipplecocktails.sections.cocktails_list.CocktailsFragmentPresenter

/**
 * 16/2/2018.
 */
@PerAppScope
@Component(modules = arrayOf(CocktailsFragmentViewModule::class, CocktailsFragmentPresenterModule::class))
interface CocktailsFragmentComponent {
    fun getCocktailsFragmentPresenter(): CocktailsFragmentPresenter
}