package aiswarya.hopes.tcs_test.data.repository

import aiswarya.hopes.tcs_test.data.local.AppDatabase
import aiswarya.hopes.tcs_test.model.BookEntity
import kotlinx.coroutines.flow.Flow

class BookRepository(private val appDatabase: AppDatabase) {
    suspend fun addBooks() {
        appDatabase.bookDao().insertAll(
            listOf(
                BookEntity(1, "Book", "author"),
                BookEntity(2, "libr", "author2"),
                BookEntity(6, "kkk", "author2")
            )
        )
    }
    fun getBooks(searchQuery: String): Flow<List<BookEntity>> {
         return appDatabase.bookDao().getTasks(searchQuery)
    }
}