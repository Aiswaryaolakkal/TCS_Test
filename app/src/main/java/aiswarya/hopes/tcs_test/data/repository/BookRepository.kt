package aiswarya.hopes.tcs_test.data.repository

import aiswarya.hopes.tcs_test.data.local.AppDatabase
import aiswarya.hopes.tcs_test.model.BookEntity
import kotlinx.coroutines.flow.Flow

class BookRepository(private val appDatabase: AppDatabase) {
    suspend fun addBooks() {
        appDatabase.bookDao().insertAll(
            listOf(
                BookEntity(1, "MATH GOLD TPE", "Al Pasha"),
                BookEntity(2, "Five Point Someone", "Chetan Bhagat"),
                BookEntity(3, "Othello", "William Shakespeare"),
                BookEntity(4, "2 States", "Chetan Bhagat"),
                BookEntity(5, "Pathummayude Aadu", "Vaikom Muhammad Basheer"),
                BookEntity(6, "Ente Katha", "Madhavikutty"),


            )
        )
    }
    fun getBooks(searchQuery: String): Flow<List<BookEntity>> {
         return appDatabase.bookDao().getTasks(searchQuery)
    }
}