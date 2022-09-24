package com.anshul.forage
import android.content.Context
import androidx.room.vo.Database

@Database(entities = [Forageable::class], version = 1, exportSchema = false)
abstract class ForageDatabase : RoomDatabase() {
    abstract fun foragableDao() : ForageableDao

    companion object {
        @Volatile
        private var INSTANCE: ForageDatabase? = null

        fun getDatabase(context: Context): ForageDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ForageDatabase::class.java,
                    "forageable_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
