package com.dehaat.dehaatassignment.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dehaat.dehaatassignment.dao.AuthorDao
import com.dehaat.dehaatassignment.dao.BookDao
import com.dehaat.dehaatassignment.model.AuthorEntity
import com.dehaat.dehaatassignment.model.BookEntity

@Database(entities = [AuthorEntity::class, BookEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract val authorDao: AuthorDao?
    abstract val bookDao: BookDao?

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                                AppDatabase::class.java, "dehaat_database").fallbackToDestructiveMigration().build()
                    }
                }
            }
            return INSTANCE
        }
    }
}