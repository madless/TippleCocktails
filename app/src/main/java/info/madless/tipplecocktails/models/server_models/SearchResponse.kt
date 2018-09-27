package info.madless.tipplecocktails.models.server_models

import com.google.gson.annotations.SerializedName

/**
 * 15/2/2018.
 */
data class SearchResponse (
        @SerializedName("drinks") val drinks: List<DrinkFullResponse>
)