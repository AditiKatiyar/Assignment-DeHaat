package com.dehaat.dehaatassignment.data_store

import android.os.AsyncTask
import android.util.Log
import com.dehaat.dehaatassignment.database.AppDatabase
import com.dehaat.dehaatassignment.listeners.UpdateMainViewListener
import com.dehaat.dehaatassignment.model.AuthorDetails
import com.dehaat.dehaatassignment.model.BookDetails

class RetrieveFromDBAsyncTask(private val database: AppDatabase,
                              private val listener: UpdateMainViewListener) : AsyncTask<Void, Void, ArrayList<AuthorDetails?>>() {

    override fun doInBackground(vararg p0: Void?): ArrayList<AuthorDetails?> {
        var list = ArrayList<AuthorDetails?>()

        val authors = database.authorDao?.getAuthors()
        authors?.forEach { author ->
            Log.d("DB", author?.name)
            author?.apply {
                val bookEntities = author.name?.let { database.bookDao?.getBooksForAuthor(it) }
                var books = ArrayList<BookDetails?>()
                bookEntities?.forEach { bookEntity ->
                    bookEntity?.apply {
                        val bookDetails = BookDetails(publishedDate, publisher, title, description, price)
                        books.add(bookDetails)
                    }
                }
                var authorDetails = AuthorDetails(author.name, author.bio, books)
                list.add(authorDetails)
            }
        }

        list.forEach { authorDetails ->
            authorDetails?.apply {
                var str = this.name + " " + this.bio
                this.books?.forEach { bookDetails ->
                    bookDetails?.apply {
                        str += this.title + " " + this.description + " " + this.publishedDate +
                                " " + this.publisher + " " + this.price
                    }
                }
                Log.d("DB", str)
            }
        }

        val l = list.size
        Log.d("DB", l.toString())

        return list
    }

    override fun onPostExecute(result: ArrayList<AuthorDetails?>?) {
        super.onPostExecute(result)
        listener.updateView(result)
    }
}