package info.madless.tipplecocktails.sections.cocktails_list

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import info.madless.tipplecocktails.R
import info.madless.tipplecocktails.models.ui_entities.Drink
import info.madless.tipplecocktails.sections.CocktailsByAlcoholFragment
import info.madless.tipplecocktails.utils.Logger
import java.util.*

/**
 * 19/3/2018.
 */

class CocktailsPagerAdapter(fragmentManager: FragmentManager, private val context: Context) : FragmentPagerAdapter(fragmentManager) {

    private val logger = Logger(this.javaClass)

    var alcoholicDrinks: List<Drink> = ArrayList()
    var nonAlcoholicDrinks: List<Drink> = ArrayList()
    var optionalDrinks: List<Drink> = ArrayList()

    override fun getItem(position: Int): Fragment {
        logger.d("getItem $position")
        val fragment = CocktailsByAlcoholFragment()
        when (position) {
            0 -> fragment.updateDrinks(alcoholicDrinks)
            1 -> fragment.updateDrinks(nonAlcoholicDrinks)
            2 -> fragment.updateDrinks(optionalDrinks)
        }
        return fragment
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

}

