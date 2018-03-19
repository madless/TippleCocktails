package info.madless.tipplecocktails.data.di

import dagger.Module
import dagger.Provides
import info.madless.tipplecocktails.data.cache.CacheService

/**
 * Created by User on 16.02.2018.
 */
@Module
class CacheServiceModule {
    @Provides
    fun provideCacheService(): CacheService {
        val cacheService = CacheService()
        return cacheService
    }
}