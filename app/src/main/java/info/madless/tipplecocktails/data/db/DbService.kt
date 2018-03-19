package info.madless.tipplecocktails.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import info.madless.tipplecocktails.data.db.dao.DrinkDao
import info.madless.tipplecocktails.data.db.dao.IngredientDao
import info.madless.tipplecocktails.models.db_entities.DrinkDb
import info.madless.tipplecocktails.models.db_entities.IngredientDb

/**
 * 20/2/2018.
 */

@Database(entities = arrayOf(DrinkDb::class, IngredientDb::class), version = 1)
@TypeConverters(IngredientConverter::class)
abstract class DbService: RoomDatabase() {
    abstract fun getDrinkDao(): DrinkDao
    abstract fun getIngredientDao(): IngredientDao
}
