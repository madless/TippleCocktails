package info.madless.tipplecocktails.sections.cocktails_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import info.madless.tipplecocktails.R
import info.madless.tipplecocktails.TippleCocktailsApp
import info.madless.tipplecocktails.sections.DaggerCocktailsFragmentComponent
import info.madless.tipplecocktails.sections.abs.BaseFragment
import info.madless.tipplecocktails.sections.cocktails_list.abs.CocktailsFragmentView
import info.madless.tipplecocktails.sections.cocktails_list.di.CocktailsFragmentComponent
import info.madless.tipplecocktails.sections.cocktails_list.di.CocktailsFragmentModule
import javax.inject.Inject

/**
 * 15/2/2018.
 */
class CocktailsFragment: BaseFragment(), CocktailsFragmentView {

    private var cocktailsFragmentComponent: CocktailsFragmentComponent? = null

    @Inject
    lateinit var presenter: CocktailsFragmentPresenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater?.inflate(R.layout.fragment_cocktails, container, false)
        return root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

        presenter.execute()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        cocktailsFragmentComponent = null
    }



    private fun init() {
        Log.d("madless", "fragment init")
        cocktailsFragmentComponent = DaggerCocktailsFragmentComponent.builder()
                .applicationComponent(TippleCocktailsApp.applicationComponent)
                .cocktailsFragmentPresenterModule(CocktailsFragmentModule(this))
                .build()

        cocktailsFragmentComponent?.inject(this)
    }
}