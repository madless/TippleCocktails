package info.madless.tipplecocktails.screens.main

import android.os.Bundle
import info.madless.tipplecocktails.R
import info.madless.tipplecocktails.screens.abs.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logger.d("Activity onCreate ${this.hashCode()} savedInstanceState $savedInstanceState")

        if(savedInstanceState == null) {
            val cocktailsFragment = CocktailsFragment()
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, cocktailsFragment)
                    .commit()
        }
    }
}
