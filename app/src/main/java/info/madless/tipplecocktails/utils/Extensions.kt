package info.madless.tipplecocktails.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * 19/3/2018.
 */
fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}