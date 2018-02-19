package info.madless.tipplecocktails.data

import dagger.Module
import dagger.Provides
import info.madless.tipplecocktails.sections.AppScope

/**
 * Created by User on 16.02.2018.
 */
@Module(includes = arrayOf(ApiServiceModule::class, CacheServiceModule::class))
class RepositoryModule {
    @Provides
    @AppScope
    fun provideRepository(apiService: ApiService, cacheService: CacheService): Repository {
        val repository = Repository(apiService, cacheService)
        return repository
    }
}