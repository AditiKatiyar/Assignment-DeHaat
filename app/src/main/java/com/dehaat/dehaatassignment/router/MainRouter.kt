package com.dehaat.dehaatassignment.router

import android.content.Context
import android.widget.Toast

class MainRouter(private val context: Context) : IMainRouter {
    override fun showErrorToast(message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}