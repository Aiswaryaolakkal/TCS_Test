package aiswarya.hopes.tcs_test.data.repository

import aiswarya.hopes.tcs_test.data.local.AppDatabase
import aiswarya.hopes.tcs_test.model.BookEntity
import kotlinx.coroutines.flow.Flow

class BookRepository(private val appDatabase: AppDatabase) {
    suspend fun addBooks() {
        if (appDatabase.bookDao().getBookList().isEmpty()) {


            appDatabase.bookDao().insertAll(
                listOf(
                    BookEntity(1, "MATH GOLD TPE", "Al Pasha", currentTimeToLong()),
                    BookEntity(2, "Five Point Someone", "Chetan Bhagat", currentTimeToLong()),
                    BookEntity(3, "Othello", "William Shakespeare", currentTimeToLong()),
                    BookEntity(4, "2 States", "Chetan Bhagat", currentTimeToLong()),
                    BookEntity(
                        5,
                        "Pathummayude Aadu",
                        "Vaikom Muhammad Basheer",
                        currentTimeToLong()
                    ),
                    BookEntity(6, "Ente Katha", "Madhavikutty", currentTimeToLong()),


                    )
            )
        }
    }

    fun getBooks(searchQuery: String): Flow<List<BookEntity>> {
        return appDatabase.bookDao().getBooks(searchQuery)
    }

    suspend fun getBookById(bookId: Int): BookEntity {
        return appDatabase.bookDao().getBookById(bookId)
    }

    fun currentTimeToLong(): Long {
        return System.currentTimeMillis()
    }

    suspend fun setOpen(id: Int, time: Long) {
        return appDatabase.bookDao().setOpenstatus(id, time)
    }

    fun getRecentBook(): Flow<List<BookEntity>> {
        return appDatabase.bookDao().getRecentBook()
    }
}