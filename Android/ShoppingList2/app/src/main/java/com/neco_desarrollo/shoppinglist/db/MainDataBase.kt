package com.neco_desarrollo.shoppinglist.db

import android.content.Context
import androidx.room.*
import androidx.room.migration.AutoMigrationSpec
import com.neco_desarrollo.shoppinglist.entities.*

@Database (entities = [LibraryItem::class, NoteItem::class,
    ShopListItem::class, ShopListNameItem::class], version = 5,
    exportSchema = true, autoMigrations = [
        AutoMigration(from = 4, to = 5, spec = MainDataBase.SpecMigration::class)
    ]
)
abstract class MainDataBase : RoomDatabase() {
    @RenameTable ( fromTableName = "library", toTableName = "help")
    class SpecMigration : AutoMigrationSpec
    abstract fun getDao(): Dao

    companion object{
        @Volatile
        private var INSTANCE: MainDataBase? = null
        fun getDataBase(context: Context): MainDataBase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MainDataBase::class.java,
                    "shopping_list.db"
                ).build()
                instance
            }
        }
    }
}