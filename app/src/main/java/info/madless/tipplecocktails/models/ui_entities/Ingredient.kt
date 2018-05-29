package info.madless.tipplecocktails.models.ui_entities

import java.io.Serializable

/**
 * 15/2/2018.
 */
data class Ingredient(
        var name: String,
        var measure: String
) : Serializable