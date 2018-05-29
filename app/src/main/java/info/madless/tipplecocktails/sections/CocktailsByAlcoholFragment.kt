package info.madless.tipplecocktails.sections

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import info.madless.tipplecocktails.R
import info.madless.tipplecocktails.models.ui_entities.Drink
import info.madless.tipplecocktails.sections.abs.BaseFragment
import kotlinx.android.synthetic.main.fragment_cocktails_by_alcohol_types.*
import java.util.*

/**
 * 15/2/2018.
 */
class CocktailsByAlcoholFragment: BaseFragment() {

    var drinks: ArrayList<Drink> = ArrayList()
    var adapter = CocktailsListAdapter()

    companion object {
        private const val KEY_DRINKS = "drinks"
        public fun getFragment(alcoholicDrinks: ArrayList<Drink>): CocktailsByAlcoholFragment {
            val fragment = CocktailsByAlcoholFragment()
            val bundle = Bundle()
            bundle.putSerializable(KEY_DRINKS, alcoholicDrinks)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.drinks = arguments.getSerializable(KEY_DRINKS) as ArrayList<Drink>
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        logger.d("Fragment onCreateView ${this.hashCode()}")
        val root = inflater?.inflate(R.layout.fragment_cocktails_by_alcohol_types, container, false)
        return root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logger.d("Fragment onViewCreated ${this.hashCode()} drinks ${drinks.size}")
        rvCocktails.adapter = adapter
        rvCocktails.layoutManager = LinearLayoutManager(context)
        adapter.drinks = drinks
        adapter.notifyDataSetChanged()
    }

    fun updateDrinks(drinks: ArrayList<Drink>) {
        logger.d("updateDrinks ${this.hashCode()}")
        this.drinks = drinks
        adapter.drinks = drinks
        adapter.notifyDataSetChanged()
    }
}