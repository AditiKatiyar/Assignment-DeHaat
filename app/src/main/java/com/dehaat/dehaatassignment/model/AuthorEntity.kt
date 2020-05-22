package com.dehaat.dehaatassignment.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class AuthorEntity(
        @PrimaryKey
        var name: String,

        var bio: String? = null
)