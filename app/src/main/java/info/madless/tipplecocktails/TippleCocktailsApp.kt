package info.madless.tipplecocktails

import android.app.Application
import info.madless.tipplecocktails.utils.Logger

/**
 * 15/2/2018.
 */
class TippleCocktailsApp: Application() {

    protected val logger: Logger = Logger(this.javaClass)

    override fun onCreate() {
        super.onCreate()
        init()
    }

    fun init() {
        logger.d("app init")
    }
}