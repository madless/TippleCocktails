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

/**
 * 15/2/2018.
 */
class CocktailsByAlcoholFragment: BaseFragment() {

    var adapter = CocktailsListAdapter()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        logger.d("Fragment onCreateView ${this.hashCode()}")
        val root = inflater?.inflate(R.layout.fragment_cocktails_by_alcohol_types, container, false)
        return root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logger.d("Fragment onViewCreated ${this.hashCode()}")
        rvCocktails.adapter = adapter
        rvCocktails.layoutManager = LinearLayoutManager(context)
        adapter.notifyDataSetChanged()
    }

    fun updateDrinks(drinks: List<Drink>) {
        logger.d("updateDrinks ${this.hashCode()}")
        adapter.drinks = drinks
        adapter.notifyDataSetChanged()
    }
}