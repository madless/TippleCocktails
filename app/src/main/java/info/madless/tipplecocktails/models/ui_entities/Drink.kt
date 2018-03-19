package info.madless.tipplecocktails.models.ui_entities

import com.google.gson.annotations.SerializedName

/**
 * 15/2/2018.
 */
data class Drink(
        @SerializedName("idDrink") var id: String,
        @SerializedName("strDrink") var name: String?,
        @SerializedName("strCategory") var category: String?,
        @SerializedName("strAlcoholic") var alcoholType: String?,
        @SerializedName("strGlass") var glassType: String?,
        @SerializedName("strInstructions") var instructions: String?,
        @SerializedName("strDrinkThumb") var cocktailImageUrl: String?,
        @SerializedName("ingredients") var ingredients: List<Ingredient>?
) {
    constructor(): this("", null, null, null, null, null, null, null)
}