package info.madless.tipplecocktails.models.db_entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * 20/2/2018.
 */
@Entity(tableName = "DRINKS")
data class DrinkDb(
        @PrimaryKey @ColumnInfo(name = "id")  @SerializedName("id") var id: String,
        @ColumnInfo(name = "name") @SerializedName("name") var name: String?,
        @ColumnInfo(name = "category") @SerializedName("category") var category: String?,
        @ColumnInfo(name = "alcoholic") @SerializedName("alcoholic") var alcoholType: String?,
        @ColumnInfo(name = "glass") @SerializedName("glass") var glassType: String?,
        @ColumnInfo(name = "instructions") @SerializedName("instructions") var instructions: String?,
        @ColumnInfo(name = "drinkThumb") @SerializedName("drinkThumb") var cocktailImageUrl: String?
) {
    constructor(): this("", null, null, null, null, null, null)
}