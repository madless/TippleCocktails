package info.madless.tipplecocktails.sections.abs

import android.support.v7.app.AppCompatActivity
import info.madless.tipplecocktails.utils.Logger

/**
 * 16/2/2018.
 */
abstract class BaseActivity: AppCompatActivity() {
    protected val logger: Logger = Logger(this.javaClass)
}