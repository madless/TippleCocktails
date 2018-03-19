package info.madless.tipplecocktails.data.di

import dagger.Module
import dagger.Provides
import info.madless.tipplecocktails.data.Repository
import info.madless.tipplecocktails.data.cache.CacheService
import info.madless.tipplecocktails.data.db.DbService
import info.madless.tipplecocktails.data.network.ApiService
import info.madless.tipplecocktails.sections.AppScope
import info.madless.tipplecocktails.utils.Logger

/**
 * Created by User on 16.02.2018.
 */
@Module(includes = arrayOf(ApiServiceModule::class, CacheServiceModule::class, DbServiceModule::class))
class RepositoryModule {
    private val logger = Logger(ApiServiceModule::class.java)

    @Provides
    @AppScope
    fun provideRepository(apiService: ApiService, cacheService: CacheService, dbService: DbService): Repository {
        val repository = Repository(apiService, cacheService, dbService)
        logger.d("provideRepository")
        return repository
    }
}