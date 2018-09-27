package info.madless.tipplecocktails.screens.abs

import android.support.v4.app.Fragment
import info.madless.tipplecocktails.utils.Logger

/**
 * 15/2/2018.
 */
abstract class BaseFragment: Fragment() {
    protected val logger: Logger = Logger(this.javaClass)
}