package info.madless.tipplecocktails

import android.app.Application
import android.util.Log
import info.madless.tipplecocktails.data.ApiServiceModule

/**
 * 15/2/2018.
 */
class TippleCocktailsApp: Application() {

    companion object {
        var applicationComponent: ApplicationComponent? = null
    }

    override fun onCreate() {
        super.onCreate()
        init()
    }

    fun init() {
        Log.d("madless", "app init")
        applicationComponent = DaggerApplicationComponent
                .builder()
                .apiServiceModule(ApiServiceModule())
                .build()
    }
}