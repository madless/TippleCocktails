package info.madless.tipplecocktails.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import info.madless.tipplecocktails.R
import info.madless.tipplecocktails.TippleCocktailsApp
import info.madless.tipplecocktails.models.ui_entities.Drink
import info.madless.tipplecocktails.screens.abs.BaseFragment
import info.madless.tipplecocktails.screens.main.abs.CocktailsFragmentView
import info.madless.tipplecocktails.screens.main.di.CocktailsFragmentComponent
import info.madless.tipplecocktails.screens.main.di.CocktailsFragmentPresenterModule
import info.madless.tipplecocktails.screens.main.di.CocktailsFragmentViewModule
import info.madless.tipplecocktails.screens.main.di.DaggerCocktailsFragmentComponent
import kotlinx.android.synthetic.main.fragment_cocktails.*

/**
 * 15/2/2018.
 */
class CocktailsFragment: BaseFragment(), CocktailsFragmentView {

    private var cocktailsFragmentComponent: CocktailsFragmentComponent? = null

    var presenter: CocktailsFragmentPresenter? = null
    var pagerAdapter: CocktailsPagerAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater?.inflate(R.layout.fragment_cocktails, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        presenter?.execute()
        logger.d("Fragment onViewCreated ${this.hashCode()}")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        cocktailsFragmentComponent = null
        logger.d("Fragment onDestroyView ${this.hashCode()}")
    }

    private fun init() {
        val cocktailsFragmentViewModule = CocktailsFragmentViewModule(this)
        val cocktailsFragmentPresenterModule = CocktailsFragmentPresenterModule(TippleCocktailsApp.repositoryComponent.getRepository())
        cocktailsFragmentComponent = DaggerCocktailsFragmentComponent.builder()
                .cocktailsFragmentViewModule(cocktailsFragmentViewModule)
                .cocktailsFragmentPresenterModule(cocktailsFragmentPresenterModule)
                .build()
        presenter = cocktailsFragmentComponent?.getCocktailsFragmentPresenter()

        pagerAdapter = CocktailsPagerAdapter(childFragmentManager, context)
        alcoholTypesPager.adapter = pagerAdapter
        alcoholTypesTabs.setupWithViewPager(alcoholTypesPager)
    }

    override fun onLoadingStarted() {
        progressBar.visibility = VISIBLE
    }

    override fun onLoadingFinished() {
        progressBar.visibility = GONE
    }

    override fun onDrinksFetched(alcoholicDrinks: ArrayList<Drink>, nonAlcoholicDrinks: ArrayList<Drink>, optionalDrinks: ArrayList<Drink>) {
        logger.d("onDrinksFetched alcoholicDrinks: ${alcoholicDrinks.size} nonAlcoholicDrinks: ${nonAlcoholicDrinks.size} optionalDrinks ${optionalDrinks.size}")
        pagerAdapter?.updateDrinks(alcoholicDrinks, nonAlcoholicDrinks, optionalDrinks)
    }
}