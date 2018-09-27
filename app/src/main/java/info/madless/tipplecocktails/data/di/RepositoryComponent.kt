package info.madless.tipplecocktails.data.di

import dagger.Component
import info.madless.tipplecocktails.AppScope
import info.madless.tipplecocktails.data.Repository

/**
 * Created by User on 16.02.2018.
 */
@AppScope
@Component(modules = arrayOf(RepositoryModule::class))
interface RepositoryComponent {
    fun getRepository(): Repository
}