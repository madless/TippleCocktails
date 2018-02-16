package info.madless.tipplecocktails.sections.cocktails_list.di

import dagger.Component
import info.madless.tipplecocktails.sections.cocktails_list.CocktailsFragmentPresenter
import javax.inject.Singleton

/**
 * 16/2/2018.
 */
@Singleton
@Component(modules = arrayOf(CocktailsFragmentViewModule::class, CocktailsFragmentPresenterModule::class))
interface CocktailsFragmentComponent {
    fun getCocktailsFragmentPresenter(): CocktailsFragmentPresenter
}