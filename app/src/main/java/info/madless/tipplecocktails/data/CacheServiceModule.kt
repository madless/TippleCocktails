package info.madless.tipplecocktails.data

import dagger.Module
import dagger.Provides

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