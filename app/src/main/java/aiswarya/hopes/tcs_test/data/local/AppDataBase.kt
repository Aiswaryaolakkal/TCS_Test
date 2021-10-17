    package aiswarya.hopes.tcs_test.data.local

import aiswarya.hopes.tcs_test.model.BookEntity
import aiswarya.hopes.tcs_test.di.ApplicationScope
import androidx.room.Database
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import javax.inject.Provider

    @Database(entities = [BookEntity::class], version = DB_VERSION)
abstract class AppDatabase  : RoomDatabase() {
    abstract fun bookDao(): BookDao

    class Callback @Inject constructor(
        private val database: Provider<AppDatabase>,
        @ApplicationScope private val applicationScope: CoroutineScope
    )

}

const val DB_VERSION = 1
