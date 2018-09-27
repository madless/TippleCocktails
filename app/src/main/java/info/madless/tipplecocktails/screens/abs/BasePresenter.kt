package info.madless.tipplecocktails.screens.abs

import info.madless.tipplecocktails.utils.Logger

/**
 * 16/2/2018.
 */
abstract class BasePresenter {
    protected val logger: Logger = Logger(this.javaClass)
}