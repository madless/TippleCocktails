package info.madless.tipplecocktails.data

import dagger.Component
import info.madless.tipplecocktails.sections.AppScope

/**
 * Created by User on 16.02.2018.
 */
@AppScope
@Component(modules = arrayOf(RepositoryModule::class))
interface RepositoryComponent {
    fun getRepositoryComponent(): RepositoryComponent
}