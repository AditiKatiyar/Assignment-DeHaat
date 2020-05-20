package com.dehaat.dehaatassignment.data_store

import android.content.Context
import android.content.Context.MODE_PRIVATE


class DataStore(val context: Context) {

    companion object {
        private val APP_SHARED_PREF = "AppSharedPref"
        private val TOKEN = "token"
    }

    fun storeAuthToken(token: String) {
        val sharedPrefEditor = context.getSharedPreferences(APP_SHARED_PREF, MODE_PRIVATE).edit()
        sharedPrefEditor.putString("", token)
        sharedPrefEditor.apply()
    }

    fun getAuthToken(): String? {
        return context.getSharedPreferences(APP_SHARED_PREF, MODE_PRIVATE)
                .getString(TOKEN, "")
    }
}