package info.madless.tipplecocktails.sections.cocktails_list.di

import dagger.Module
import dagger.Provides
import info.madless.tipplecocktails.sections.PerActivity
import info.madless.tipplecocktails.sections.cocktails_list.abs.CocktailsFragmentView

/**
 * 16/2/2018.
 */
@Module
class CocktailsFragmentModule(private val cocktailsFragmentView: CocktailsFragmentView) {

    @Provides @PerActivity
    fun providesCocktailsFragmentView(): CocktailsFragmentView = cocktailsFragmentView

}