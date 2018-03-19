package info.madless.tipplecocktails.data.db

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import info.madless.tipplecocktails.models.ui_entities.Ingredient
import java.util.*





/**
 * 20/2/2018.
 */
class IngredientConverter {
    @TypeConverter
    fun fromString(value: String): ArrayList<Ingredient> {
        val listType = object : TypeToken<ArrayList<Ingredient>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayLisr(list: ArrayList<Ingredient>): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}