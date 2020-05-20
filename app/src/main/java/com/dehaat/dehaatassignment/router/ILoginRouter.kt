package com.dehaat.dehaatassignment.router

interface ILoginRouter {
    fun showEmailErrorDialog()
    fun showPasswordErrorDialog()
    fun showErrorToast(message: String?)
    fun openMainActivity()
}