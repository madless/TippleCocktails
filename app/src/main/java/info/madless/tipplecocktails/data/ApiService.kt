package info.madless.tipplecocktails.data

import info.madless.tipplecocktails.server_models.DrinkShortResponse
import info.madless.tipplecocktails.server_models.IngredientFullResponse
import info.madless.tipplecocktails.server_models.SearchResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * 15/2/2018.
 */
interface ApiService {
    @GET("search.php")
    fun searchCocktailByName(@Query("s") cocktailName: String): Observable<SearchResponse>

    @GET("lookup.php")
    fun searchCocktailById(@Query("i") id: String): Observable<SearchResponse>

    @GET("search.php")
    fun searchIngredientByName(@Query("i") ingredientName: String): Observable<IngredientFullResponse>

    @GET("filter.php")
    fun filterCocktailByAlcoholic(@Query("a") alcoholicType: String): Observable<DrinkShortResponse>

    @GET("filter.php")
    fun filterCocktailByIngredient(@Query("i") ingredientName: String): Observable<DrinkShortResponse>

    @GET("filter.phh")
    fun filterCocktailByCategory(@Query("c") category: String): Observable<DrinkShortResponse>

//    /**
//     * Companion object to create the ApiService
//     */
//    companion object Factory {
//        fun create(): ApiService {
//            val client = buildOkHttpClientInstance()
//            val retrofit = Retrofit.Builder()
//                    .client(client)
//                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .baseUrl("http://www.thecocktaildb.com/api/json/v1/1/")
//                    .build()
//            return retrofit.create(ApiService::class.java)
//        }
//
//        private fun buildOkHttpClientInstance(): OkHttpClient {
//            val interceptor = HttpLoggingInterceptor()
//            interceptor.level = HttpLoggingInterceptor.Level.BODY
//            return OkHttpClient.Builder()
//                    .connectTimeout(15, TimeUnit.SECONDS)
//                    .readTimeout(15, TimeUnit.SECONDS)
//                    .addInterceptor(interceptor)
//                    .build()
//        }
//    }


}