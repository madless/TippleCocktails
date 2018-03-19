package info.madless.tipplecocktails

import android.content.Context
import dagger.Module
import dagger.Provides



/**
 * 20/2/2018.
 */
@Module
class AppContextModule(private var context: Context) {
    @Provides
    fun context(): Context {
        return context.applicationContext
    }
}