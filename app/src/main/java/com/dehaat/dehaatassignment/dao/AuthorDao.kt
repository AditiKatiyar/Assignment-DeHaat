package com.dehaat.dehaatassignment.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.dehaat.dehaatassignment.model.AuthorEntity

@Dao
interface AuthorDao {

    @Update
    fun saveAuthor(author: AuthorEntity)

    @Query("select * from AuthorEntity")
    fun getAuthors(): List<AuthorEntity?>?
}