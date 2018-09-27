package info.madless.tipplecocktails.screens.main

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import info.madless.tipplecocktails.R
import info.madless.tipplecocktails.models.ui_entities.Drink
import info.madless.tipplecocktails.utils.Logger



/**
 * 19/3/2018.
 */

class CocktailsPagerAdapter(fragmentManager: FragmentManager, private val context: Context?) : FragmentStatePagerAdapter(fragmentManager) {

    private val logger = Logger(this.javaClass)

    companion object {
        private const val FRAGMENTS_COUNT = 3
    }

    private var data: ArrayList<ArrayList<Drink>> = ArrayList()
    private var fragments = Array<CocktailsByTypeFragment?>(3, { _ -> null})

    override fun getItem(position: Int): Fragment {
        logger.d("getItem $position")
        if (fragments[position] == null) {
            val fragment = CocktailsByTypeFragment.getFragment(data[position])
            fragments[position] = fragment
        }
        return fragments[position]!!
    }

    override fun getCount(): Int {
        return data.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return context?.getString(R.string.cocktail_type_alcoholic)
            1 -> return context?.getString(R.string.cocktail_type_non_alcoholic)
            2 -> return context?.getString(R.string.cocktail_type_optional)
        }
        return super.getPageTitle(position)
    }

    fun updateDrinks(alcoholicDrinks: ArrayList<Drink>, nonAlcoholicDrinks: ArrayList<Drink>, optionalDrinks: ArrayList<Drink>) {
        logger.d("updateDrinks")
        data.clear()
        data.add(alcoholicDrinks)
        data.add(nonAlcoholicDrinks)
        data.add(optionalDrinks)
        notifyDataSetChanged()
    }
}

