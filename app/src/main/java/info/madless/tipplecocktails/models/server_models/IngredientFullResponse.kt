package info.madless.tipplecocktails.models.server_models

import com.google.gson.annotations.SerializedName

/**
 * 15/2/2018.
 */
data class IngredientFullResponse (
        @SerializedName("idIngredient") val id: String,
        @SerializedName("strIngredient") val name: String,
        @SerializedName("strDescription") val description: String,
        @SerializedName("strType") val type: String
)