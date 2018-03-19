package info.madless.tipplecocktails.models.ui_entities

import com.google.gson.annotations.SerializedName

/**
 * 20/2/2018.
 */
data class IngredientInfo(
        @SerializedName("idIngredient") var id: String,
        @SerializedName("strIngredient") var name: String?,
        @SerializedName("strDescription") var description: String?,
        @SerializedName("strType") var type: String?
)