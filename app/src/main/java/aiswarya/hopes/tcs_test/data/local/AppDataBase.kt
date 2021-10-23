package aiswarya.hopes.tcs_test.data.local

import aiswarya.hopes.tcs_test.model.BookEntity
import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [BookEntity::class], version = DB_VERSION)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao


}

const val DB_VERSION = 1
