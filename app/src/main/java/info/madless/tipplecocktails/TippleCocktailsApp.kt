package info.madless.tipplecocktails

import android.app.Application
import android.content.Context
import info.madless.tipplecocktails.data.di.DaggerRepositoryComponent
import info.madless.tipplecocktails.data.di.DbServiceModule
import info.madless.tipplecocktails.data.di.RepositoryComponent
import info.madless.tipplecocktails.utils.Logger

/**
 * 15/2/2018.
 */
class TippleCocktailsApp: Application() {
    private val logger: Logger = Logger(this.javaClass)

    companion object {
        lateinit var repositoryComponent: RepositoryComponent
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        init()
    }

    fun init() {
        val dbServiceModule = DbServiceModule(applicationContext)
        repositoryComponent = DaggerRepositoryComponent.builder()
                .dbServiceModule(dbServiceModule)
                .build()
        appContext = applicationContext
    }
}