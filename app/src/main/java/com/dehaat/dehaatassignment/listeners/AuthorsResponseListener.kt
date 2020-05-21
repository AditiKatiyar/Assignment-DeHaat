package com.dehaat.dehaatassignment.listeners

import com.dehaat.dehaatassignment.model.Data
import retrofit2.Response

interface AuthorsResponseListener {
    fun onResponse(response: Response<Data?>)
    fun onError(errorMessage: String?)
}