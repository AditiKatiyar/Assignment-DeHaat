package com.dehaat.dehaatassignment.presenter

import android.content.Context
import android.util.Patterns
import com.dehaat.dehaatassignment.activity.ILoginView
import com.dehaat.dehaatassignment.data_store.DataStore
import com.dehaat.dehaatassignment.interactor.ILoginInteractor
import com.dehaat.dehaatassignment.interactor.LoginInteractor
import com.dehaat.dehaatassignment.listeners.UserAuthResonseListener
import com.dehaat.dehaatassignment.model.UserAuthDetails
import com.dehaat.dehaatassignment.router.ILoginRouter
import retrofit2.Response

class LoginPresenter(private val view: ILoginView,
                     private val router: ILoginRouter,
                     private val context: Context) : ILoginPresenter, UserAuthResonseListener {

    private val interactor: ILoginInteractor by lazy { LoginInteractor() }

    override fun onLoginButtonClick(email: String, password: String) {
        if (!isValidEmail(email)) {
            router.showEmailErrorDialog()
            return
        }

        if (!isValidPassword(password)) {
            router.showPasswordErrorDialog()
            return
        }

        interactor.authenticateUser(email, password, this)
    }

    override fun checkIfAlreadyLoggedIn() {
        val token = DataStore(context).getAuthToken()
        if (token != null && token != "") {
            router.openMainActivity()
        }
    }

    private fun isValidEmail(email: String?): Boolean {
        email?.apply {
            return !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }
        return false
    }

    private fun isValidPassword(password: String?): Boolean {
        password?.apply {
            return !isNullOrEmpty() && this.length >= 8
        }
        return false
    }

    override fun onResponse(response: Response<UserAuthDetails?>) {
        response.body()?.apply {
            this.authToken?.let { token ->
                DataStore(context).storeAuthToken(token)
                router.openMainActivity()
            }
        } ?: run {
            router.showErrorToast("Something went wrong! Please try again")
        }
    }

    override fun onError(errorMessage: String?) {
        router.showErrorToast("Something went wrong! Please try again")
    }

}