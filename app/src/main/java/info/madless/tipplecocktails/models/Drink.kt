package info.madless.tipplecocktails.models

import com.google.gson.annotations.SerializedName

/**
 * 15/2/2018.
 */
data class Drink(
        @SerializedName("idDrink") val id: String,
        @SerializedName("strDrink") val name: String,
        @SerializedName("strCategory") val category: String,
        @SerializedName("strIBA") val iba: String,
        @SerializedName("strAlcoholic") val alcoholType: String,
        @SerializedName("strGlass") val glassType: String,
        @SerializedName("strInstructions") val instructions: String,
        @SerializedName("strDrinkThumb") val cocktailImageUrl: String
)