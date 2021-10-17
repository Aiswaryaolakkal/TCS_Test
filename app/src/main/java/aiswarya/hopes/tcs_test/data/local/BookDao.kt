package aiswarya.hopes.tcs_test.data.local

import aiswarya.hopes.tcs_test.model.BookEntity
import androidx.room.*

import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {
    @Query("SELECT * FROM books WHERE name LIKE '%' || :searchQuery || '%' ")
    fun getTasks(searchQuery: String): Flow<List<BookEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task: BookEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertAll(books: List<BookEntity>)

    @Update
    suspend fun update(task: BookEntity)

    @Delete
    suspend fun delete(task: BookEntity)


}