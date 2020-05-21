package com.dehaat.dehaatassignment.presenter

import com.dehaat.dehaatassignment.listeners.UpdateMainViewListener

interface IMainPresenter {
    fun fetchAuthors(listener: UpdateMainViewListener)
    fun onLogoutOptionClick()
}