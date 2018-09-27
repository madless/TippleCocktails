package info.madless.tipplecocktails.data.di

import dagger.Module
import dagger.Provides
import info.madless.tipplecocktails.AppScope
import info.madless.tipplecocktails.data.network.ApiService
import info.madless.tipplecocktails.utils.Const
import info.madless.tipplecocktails.utils.Logger
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * 15/2/2018.
 */
@Module
class ApiServiceModule {

    private val logger = Logger(ApiServiceModule::class.java)

    @Provides
    @AppScope
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BASIC
        return interceptor
    }

    @Provides
    @AppScope
    fun provideHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build()
    }

    @Provides
    @AppScope
    fun provideRetrofit(httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(Const.BASE_COCKTAILSDB_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build()
    }

    @Provides
    @AppScope
    fun providesApiService(retrofit: Retrofit): ApiService {
        logger.d("providesApiService")
        return retrofit.create(ApiService::class.java)
    }

}