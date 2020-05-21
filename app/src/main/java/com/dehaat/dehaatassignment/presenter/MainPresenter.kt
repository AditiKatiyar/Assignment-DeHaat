package com.dehaat.dehaatassignment.presenter

import android.content.Context
import com.dehaat.dehaatassignment.activity.IMainView
import com.dehaat.dehaatassignment.data_store.DataStore
import com.dehaat.dehaatassignment.interactor.IMainInteractor
import com.dehaat.dehaatassignment.interactor.MainInteractor
import com.dehaat.dehaatassignment.listeners.AuthorsResponseListener
import com.dehaat.dehaatassignment.listeners.UpdateMainViewListener
import com.dehaat.dehaatassignment.model.Data
import com.dehaat.dehaatassignment.router.IMainRouter
import retrofit2.Response

class MainPresenter(private val view: IMainView,
                    private val router: IMainRouter,
                    private val context: Context) : IMainPresenter {

    private val interactor: IMainInteractor by lazy { MainInteractor() }

    override fun fetchAuthors(listener: UpdateMainViewListener) {
        interactor.fetchAuthors(object : AuthorsResponseListener {
            override fun onResponse(response: Response<Data?>) {
                response.body()?.list?.let { list ->
                    // update view
                    listener.updateView(list)
                    // update in cache or DB

                } ?: run {
                    // show error toast
                    router.showErrorToast("Something went wrong!")
                }
            }

            override fun onError(errorMessage: String?) {
                // show error toast
                router.showErrorToast("Something went wrong!")
            }

        })
    }

    override fun onLogoutOptionClick() {
        DataStore(context).eraseAuthToken()
        router.openLoginActivity()
    }

}