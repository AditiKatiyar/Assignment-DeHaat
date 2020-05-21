package com.dehaat.dehaatassignment.interactor

import com.dehaat.dehaatassignment.listeners.AuthorsResponseListener

interface IMainInteractor {
    fun fetchAuthors(listener: AuthorsResponseListener)
}