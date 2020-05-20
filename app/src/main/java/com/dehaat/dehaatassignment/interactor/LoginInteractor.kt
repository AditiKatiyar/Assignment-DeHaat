package com.dehaat.dehaatassignment.interactor

import com.dehaat.dehaatassignment.listeners.UserAuthResonseListener
import com.dehaat.dehaatassignment.model.UserAuthDetails
import com.dehaat.dehaatassignment.rest.AppRestClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginInteractor: ILoginInteractor {
    override fun authenticateUser(email: String, password: String, listener: UserAuthResonseListener) {
        val call = AppRestClient.getInstance()
                .appRestClientService
                .login(email, password)

        call.enqueue(object : Callback<UserAuthDetails?> {
            override fun onResponse(call: Call<UserAuthDetails?>, response: Response<UserAuthDetails?>) {
                listener.onResponse(response)
            }

            override fun onFailure(call: Call<UserAuthDetails?>, t: Throwable) {
                listener.onError(t.message)
            }
        })
    }
}