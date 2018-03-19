package info.madless.tipplecocktails.data.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import info.madless.tipplecocktails.models.db_entities.IngredientDb

/**
 * 20/2/2018.
 */
@Dao
interface IngredientDao {
    @Query("SELECT * FROM INGREDIENTS")
    fun getAllIngredients(): List<IngredientDb>

    @Query("SELECT * FROM INGREDIENTS WHERE drinkId = :arg0")
    fun getIngredientsByDrink(drinkId: String): List<IngredientDb>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertIngredient(ingredientDb: IngredientDb)

    @Query("DELETE FROM INGREDIENTS")
    fun deleteAllIngredients()
}