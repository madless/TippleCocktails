package info.madless.tipplecocktails

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import info.madless.tipplecocktails.sections.cocktails_list.CocktailsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cocktailsFragment = CocktailsFragment()
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, cocktailsFragment)
                .commit()

//        val repository = RepositoryProvider.provideRepository()
//        repository.searchCocktailByName("margarita")
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe({ result ->
//                    Log.d("madless", "Margarita: $result")
//                }, { error ->
//                    error.printStackTrace()
//                })
    }
}
