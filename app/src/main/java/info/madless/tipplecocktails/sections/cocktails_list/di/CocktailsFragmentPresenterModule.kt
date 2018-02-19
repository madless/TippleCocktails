package info.madless.tipplecocktails.sections.cocktails_list.di

import dagger.Module
import dagger.Provides
import info.madless.tipplecocktails.data.Repository
import info.madless.tipplecocktails.data.RepositoryModule
import info.madless.tipplecocktails.sections.AppScope
import info.madless.tipplecocktails.sections.cocktails_list.CocktailsFragmentPresenter
import info.madless.tipplecocktails.sections.cocktails_list.abs.CocktailsFragmentView

/**
 * 16/2/2018.
 */
@Module(includes = arrayOf(RepositoryModule::class, CocktailsFragmentViewModule::class))
class CocktailsFragmentPresenterModule {
    @Provides
    @AppScope
    fun providesCocktailsFragmentPresenter(cocktailsFragmentView: CocktailsFragmentView, repository: Repository): CocktailsFragmentPresenter {
        return CocktailsFragmentPresenter(cocktailsFragmentView, repository)
    }
}