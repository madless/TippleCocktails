package info.madless.tipplecocktails.models.server_models

import com.google.gson.annotations.SerializedName

/**
 * 15/2/2018.
 */
data class DrinkShortResponse (
        @SerializedName("idDrink") val id: String,
        @SerializedName("strDrink") val name: String,
        @SerializedName("strDrinkThumb") val cocktailImageUrl: String
)