package info.madless.tipplecocktails.models.db_entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey

/**
 * 20/2/2018.
 */
@Entity(tableName = "INGREDIENTS",
        primaryKeys = arrayOf("name", "measure"),
        foreignKeys = arrayOf(ForeignKey(entity = DrinkDb::class, parentColumns = arrayOf("id"), childColumns = arrayOf("drinkId")))
)
data class IngredientDb(
        @ColumnInfo(name = "drinkId") var drinkId: String,
        @ColumnInfo(name = "name")  var name: String,
        @ColumnInfo(name = "measure") var measure: String
) {
    constructor(): this("", "", "")
}