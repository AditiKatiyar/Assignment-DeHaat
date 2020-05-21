package com.dehaat.dehaatassignment.interactor

import com.dehaat.dehaatassignment.listeners.AuthorsResponseListener
import com.dehaat.dehaatassignment.model.Data
import com.dehaat.dehaatassignment.rest.AppRestClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainInteractor : IMainInteractor {
    override fun fetchAuthors(listener: AuthorsResponseListener) {
        val call = AppRestClient.getInstance()
                .appRestClientService
                .listOfAuthors

        call.enqueue(object : Callback<Data?> {
            override fun onResponse(call: Call<Data?>, response: Response<Data?>) {
                listener.onResponse(response)
            }

            override fun onFailure(call: Call<Data?>, t: Throwable) {
                listener.onError(t.message)
            }
        })

    }
}