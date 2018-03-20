package info.madless.tipplecocktails.sections.cocktails_list

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import info.madless.tipplecocktails.R
import info.madless.tipplecocktails.models.ui_entities.Drink
import info.madless.tipplecocktails.sections.CocktailsByAlcoholFragment
import info.madless.tipplecocktails.utils.Logger

/**
 * 19/3/2018.
 */

class CocktailsPagerAdapter(fragmentManager: FragmentManager, private val context: Context) : FragmentPagerAdapter(fragmentManager) {

    private val logger = Logger(this.javaClass)

//    var alcoholicDrinks: List<Drink> = ArrayList()
//    var nonAlcoholicDrinks: List<Drink> = ArrayList()
//    var optionalDrinks: List<Drink> = ArrayList()

    var fragmentAlcoholicDrinks = CocktailsByAlcoholFragment()
    var fragmentNonAlcoholicDrinks = CocktailsByAlcoholFragment()
    var fragmentOptionalDrinks = CocktailsByAlcoholFragment()

    override fun getItem(position: Int): Fragment {
        logger.d("getItem $position")
        when (position) {
            0 -> return fragmentAlcoholicDrinks
            1 -> return fragmentNonAlcoholicDrinks
            2 -> return fragmentOptionalDrinks
        }
        return fragmentAlcoholicDrinks
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence {
        when (position) {
            0 -> return context.getString(R.string.cocktail_type_alcoholic)
            1 -> return context.getString(R.string.cocktail_type_non_alcoholic)
            2 -> return context.getString(R.string.cocktail_type_optional)
        }
        return super.getPageTitle(position)
    }

    fun updateDrinks(alcoholicDrinks: List<Drink>, nonAlcoholicDrinks: List<Drink>, optionalDrinks: List<Drink>) {
        logger.d("updateDrinks")
        fragmentAlcoholicDrinks.updateDrinks(alcoholicDrinks)
        fragmentNonAlcoholicDrinks.updateDrinks(nonAlcoholicDrinks)
        fragmentOptionalDrinks.updateDrinks(optionalDrinks)
    }
}

