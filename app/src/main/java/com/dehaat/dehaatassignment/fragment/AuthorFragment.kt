package com.dehaat.dehaatassignment.fragment


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dehaat.dehaatassignment.R
import com.dehaat.dehaatassignment.adapter.AuthorAdapter
import com.dehaat.dehaatassignment.model.AuthorDetails

/**
 * A simple [Fragment] subclass.
 */
class AuthorFragment : Fragment(R.layout.fragment_author) {

    companion object {
        private val MESSAGE_DATA = "message_data"
        private val IS_LANDSCAPE = "is_landscape"

        fun getInstance(list: ArrayList<AuthorDetails?>?, isLandscape: Boolean): AuthorFragment {
            val bundle = Bundle()
            bundle.putParcelableArrayList(MESSAGE_DATA, list)
            bundle.putBoolean(IS_LANDSCAPE, isLandscape)
            val fragment = AuthorFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.author_rv)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val list = arguments?.getParcelableArrayList<AuthorDetails?>(MESSAGE_DATA)
        val isLandscape = arguments?.getBoolean(IS_LANDSCAPE)
        list?.apply { recyclerView.adapter = AuthorAdapter(context, list, isLandscape) }
    }

}
