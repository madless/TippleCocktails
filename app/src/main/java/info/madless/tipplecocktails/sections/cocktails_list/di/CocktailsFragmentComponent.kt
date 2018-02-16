package info.madless.tipplecocktails.sections.cocktails_list.di

import dagger.Component
import info.madless.tipplecocktails.ApplicationComponent
import info.madless.tipplecocktails.sections.PerActivity
import info.madless.tipplecocktails.sections.cocktails_list.CocktailsFragment

/**
 * 16/2/2018.
 */
@PerActivity
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(CocktailsFragmentModule::class))
interface CocktailsFragmentComponent {
    fun inject(cocktailsFragment: CocktailsFragment)
}