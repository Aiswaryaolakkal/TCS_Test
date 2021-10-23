package aiswarya.hopes.tcs_test.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class BookEntity(
    @PrimaryKey(autoGenerate = false) val id: Int = 0,
    @ColumnInfo(name = "name")
    var bookName: String? = null,
    @ColumnInfo(name = "author_name")
    var authorName: String? = null,
    @ColumnInfo(name = "open_time")
    var open_time: Long? = null,
    @ColumnInfo(name = "is_open")
    var isopen: Boolean = false
)

