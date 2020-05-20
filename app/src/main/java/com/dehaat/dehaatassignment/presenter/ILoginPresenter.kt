package com.dehaat.dehaatassignment.presenter

interface ILoginPresenter {
    fun onLoginButtonClick(email: String, password: String)
    fun checkIfAlreadyLoggedIn()
}