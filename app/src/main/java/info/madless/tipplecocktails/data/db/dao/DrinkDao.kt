package info.madless.tipplecocktails.data.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import info.madless.tipplecocktails.models.db_entities.DrinkDb

/**
 * 20/2/2018.
 */

@Dao
interface DrinkDao {
    @Query("SELECT * FROM DRINKS")
    fun getAllDrinks(): List<DrinkDb>

    @Query("SELECT * FROM DRINKS WHERE alcoholic = :arg0")
    fun getDrinksByAlcoholicType(alcoholType: String): List<DrinkDb>

    @Insert(onConflict = REPLACE)
    fun insertDrink(drinkDb: DrinkDb)

    @Query("DELETE FROM DRINKS")
    fun deleteAllDrinks()
}