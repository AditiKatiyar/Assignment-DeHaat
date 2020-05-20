package com.dehaat.dehaatassignment.listeners

import com.dehaat.dehaatassignment.model.UserAuthDetails
import retrofit2.Response

interface UserAuthResonseListener {
    fun onResponse(response: Response<UserAuthDetails?>)
    fun onError(errorMessage: String?)
}