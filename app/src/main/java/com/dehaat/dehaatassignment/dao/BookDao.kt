package com.dehaat.dehaatassignment.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.dehaat.dehaatassignment.model.BookEntity

@Dao
interface BookDao {

    @Update
    fun saveBook(book: BookEntity)

    @Query("select * from BookEntity where authorName = :author")
    fun getBooksForAuthor(author: String): List<BookEntity?>?

    @Query("delete from BookEntity")
    fun deleteBooks()
}