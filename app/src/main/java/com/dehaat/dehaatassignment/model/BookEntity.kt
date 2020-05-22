package com.dehaat.dehaatassignment.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class BookEntity(

        var authorName: String,

        @PrimaryKey
        val title: String,

        val description: String? = null,

        val publisher: String? = null,

        val publishedDate: String? = null,

        val price: String? = null
)