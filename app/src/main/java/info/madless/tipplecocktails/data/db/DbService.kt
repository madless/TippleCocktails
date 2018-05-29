package info.madless.tipplecocktails.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import android.os.Environment
import info.madless.tipplecocktails.data.db.dao.DrinkDao
import info.madless.tipplecocktails.data.db.dao.IngredientDao
import info.madless.tipplecocktails.models.db_entities.DrinkDb
import info.madless.tipplecocktails.models.db_entities.IngredientDb
import info.madless.tipplecocktails.utils.Logger
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream


/**
 * 20/2/2018.
 */

@Database(entities = arrayOf(DrinkDb::class, IngredientDb::class), version = 1)
@TypeConverters(IngredientConverter::class)
abstract class DbService: RoomDatabase() {
    abstract fun getDrinkDao(): DrinkDao
    abstract fun getIngredientDao(): IngredientDao

    companion object {
        fun exportDatabse(context: Context, databaseName: String) {
            Logger.d(DbService::class.java, "Exporting db...")
            try {
                val downloadsFolder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                val data = Environment.getDataDirectory()

                if (downloadsFolder.canWrite()) {
                    val currentDBPath = "//data//" + context.packageName + "//databases//" + databaseName + ""
                    val backupDBPath = "backup_$databaseName"
                    val currentDB = File(data, currentDBPath)
                    val backupDB = File(downloadsFolder, backupDBPath)
                    Logger.d(DbService::class.java, "Exporting db to $backupDB started...")
                    if (currentDB.exists()) {
                        val src = FileInputStream(currentDB).channel
                        val dst = FileOutputStream(backupDB).channel
                        dst.transferFrom(src, 0, src.size())
                        src.close()
                        dst.close()
                    }
                    Logger.d(DbService::class.java, "Exporting db to $backupDB finished!")
                } else {
                    Logger.w(DbService::class.java, "Can't write to $downloadsFolder")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
