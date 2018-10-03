package info.madless.tipplecocktails.screens.main

import android.app.Activity
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.request.RequestOptions
import info.madless.tipplecocktails.R
import info.madless.tipplecocktails.models.ui_entities.Drink
import info.madless.tipplecocktails.screens.main.abs.OnCocktailClickedListener
import info.madless.tipplecocktails.utils.Logger
import info.madless.tipplecocktails.utils.inflate
import kotlinx.android.synthetic.main.item_cocktail.view.*

/**
 * 19/3/2018.
 */

class CocktailsListAdapter : RecyclerView.Adapter<CocktailsListAdapter.CocktailViewHolder>() {

    private val logger: Logger = Logger(this.javaClass)
    var drinks: List<Drink> = ArrayList()
    var cocktailClickedListener: OnCocktailClickedListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CocktailViewHolder(parent.inflate(R.layout.item_cocktail))

    override fun onBindViewHolder(holder: CocktailViewHolder, position: Int) = holder.bind(drinks[position])

    override fun getItemCount() = drinks.size

    inner class CocktailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(drink: Drink) = with(itemView) {
            val activity = context as? Activity
            if (activity != null && !activity.isDestroyed && !activity.isFinishing) {
                val options = RequestOptions()
                        .transforms(FitCenter())
                val uri = Uri.parse(drink.cocktailImageUrl)
                Glide.with(activity)
                        .load(uri)
                        .apply(options)
                        .into(ivCocktail)
            }
            tvTitle.text = drink.name
            tvDetails.text = drink.category
            itemView.setOnClickListener {
                cocktailClickedListener?.onCocktailClicked(drinks[adapterPosition])
            }
        }
    }
}
