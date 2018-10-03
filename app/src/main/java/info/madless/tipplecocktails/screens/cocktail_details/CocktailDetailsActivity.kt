package info.madless.tipplecocktails.screens.cocktail_details

import android.os.Bundle
import info.madless.tipplecocktails.R
import info.madless.tipplecocktails.screens.abs.BaseActivity

class CocktailDetailsActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cocktail_details)
    }
}