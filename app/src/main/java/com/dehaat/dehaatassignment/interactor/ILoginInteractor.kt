package com.dehaat.dehaatassignment.interactor

import com.dehaat.dehaatassignment.listeners.UserAuthResonseListener

interface ILoginInteractor {
    fun authenticateUser(email: String, password: String, listener: UserAuthResonseListener)
}