package com.dehaat.dehaatassignment.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data(
        @SerializedName("data") val list: ArrayList<AuthorDetails?>? = null
) : Parcelable

@Parcelize
data class AuthorDetails(
        @SerializedName("author_name") val name: String? = null,
        @SerializedName("author_bio") val bio: String? = null,
        @SerializedName("books") val books: ArrayList<BookDetails?>? = null
) : Parcelable

@Parcelize
data class BookDetails(
        @SerializedName("published_date") val publishedDate: String? = null,
        @SerializedName("publisher") val publisher: String? = null,
        @SerializedName("title") val title: String? = null,
        @SerializedName("description") val description: String? = null,
        @SerializedName("price") val price: String? = null
) : Parcelable