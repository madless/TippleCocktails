package info.madless.tipplecocktails.data.di

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import info.madless.tipplecocktails.AppScope
import info.madless.tipplecocktails.data.db.DbService
import info.madless.tipplecocktails.utils.Const
import info.madless.tipplecocktails.utils.Logger

/**
 * 20/2/2018.
 */
@Module()
class DbServiceModule(private var context: Context) {
    private val logger = Logger(ApiServiceModule::class.java)

    @Provides
    @AppScope
    fun providesDbService(): DbService {
        return Room.databaseBuilder(context.applicationContext, DbService::class.java, Const.COCKTAILS_DB_NAME)
                .allowMainThreadQueries()
                .build()
    }
}
