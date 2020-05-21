package com.dehaat.dehaatassignment.listeners

import com.dehaat.dehaatassignment.model.AuthorDetails

interface UpdateMainViewListener {
    fun updateView(list: ArrayList<AuthorDetails?>?)
}