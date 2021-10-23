package aiswarya.hopes.tcs_test.data.local

import aiswarya.hopes.tcs_test.model.BookEntity
import androidx.room.*

import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {
    @Query("SELECT * FROM books WHERE name LIKE '%' || :searchQuery || '%' ")
    fun getBooks(searchQuery: String): Flow<List<BookEntity>>

    @Query("SELECT * FROM books")
    suspend fun getBookList(): List<BookEntity>

    @Query("SELECT * FROM books WHERE id=:bookId")
    suspend fun getBookById(bookId: Int): BookEntity

    @Query("SELECT * FROM books WHERE is_open= 1 ORDER BY open_time DESC Limit 2")
    fun getRecentBook(): Flow<List<BookEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task: BookEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(books: List<BookEntity>)

    @Update
    suspend fun update(bookEntity: BookEntity)

    @Query("UPDATE books SET open_time=:time ,is_open=1 WHERE id = :id  ")
    suspend fun setOpenstatus(id: Int, time: Long)

    @Delete
    suspend fun delete(bookEntity: BookEntity)


}