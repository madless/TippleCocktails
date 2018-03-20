package info.madless.tipplecocktails.sections

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import info.madless.tipplecocktails.R
import info.madless.tipplecocktails.models.ui_entities.Drink
import info.madless.tipplecocktails.utils.inflate
import kotlinx.android.synthetic.main.item_cocktail.view.*

/**
 * 19/3/2018.
 */

class CocktailsListAdapter : RecyclerView.Adapter<CocktailsListAdapter.CocktailViewHolder>() {

    var drinks: List<Drink> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CocktailViewHolder(parent.inflate(R.layout.item_cocktail))

    override fun onBindViewHolder(holder: CocktailViewHolder, position: Int) = holder.bind(drinks[position])

    override fun getItemCount() = drinks.size

    inner class CocktailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(drink: Drink) = with(itemView) {
            tvTitle.text = drink.name
//            tvDetails.text = drink.
        }
    }
}
