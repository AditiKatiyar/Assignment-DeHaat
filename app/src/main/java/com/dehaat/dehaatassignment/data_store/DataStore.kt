package com.dehaat.dehaatassignment.data_store

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.dehaat.dehaatassignment.database.AppDatabase
import com.dehaat.dehaatassignment.listeners.UpdateMainViewListener
import com.dehaat.dehaatassignment.model.AuthorDetails
import com.dehaat.dehaatassignment.model.AuthorEntity
import com.dehaat.dehaatassignment.model.BookEntity


class DataStore(val context: Context) {

    private val database: AppDatabase? = AppDatabase.getDatabase(context)


    companion object {
        private val APP_SHARED_PREF = "AppSharedPref"
        private val TOKEN = "token"
    }

    fun storeAuthToken(token: String) {
        val sharedPrefEditor = context.getSharedPreferences(APP_SHARED_PREF, MODE_PRIVATE).edit()
        sharedPrefEditor.putString(TOKEN, token)
        sharedPrefEditor.apply()
    }

    fun getAuthToken(): String? {
        return context.getSharedPreferences(APP_SHARED_PREF, MODE_PRIVATE)
                .getString(TOKEN, "")
    }

    fun eraseAuthToken() {
        val sharedPrefEditor = context.getSharedPreferences(APP_SHARED_PREF, MODE_PRIVATE).edit()
        sharedPrefEditor.remove(TOKEN)
        sharedPrefEditor.apply()
    }

    fun saveToDatabase(list: ArrayList<AuthorDetails?>) {
        Thread {
            list.forEach { authorDetails ->

                authorDetails?.let { authorDetail ->

                    if (authorDetail.name != null) {
                        var author = AuthorEntity(authorDetail.name, authorDetail.bio)
                        database?.authorDao?.saveAuthor(author)

                        authorDetail.books?.forEach { book ->
                            book?.apply {
                                if (title != null) {
                                    var book = BookEntity(authorDetail.name, title, description, publisher, publishedDate, price)
                                    database?.bookDao?.saveBook(book)

                                }
                            }
                        }
                    }

                }
            }

        }.start()
    }

    fun updateFromDatabase(listener: UpdateMainViewListener) {
        if (database != null) {
            RetrieveFromDBAsyncTask(database, listener).execute()
        }
    }

    fun eraseDB() {
        Thread {
            database?.authorDao?.deleteAuthors()
            database?.bookDao?.deleteBooks()
        }.start()
    }
}