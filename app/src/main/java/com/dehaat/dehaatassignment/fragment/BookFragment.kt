package com.dehaat.dehaatassignment.fragment


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dehaat.dehaatassignment.R
import com.dehaat.dehaatassignment.adapter.BookAdapter
import com.dehaat.dehaatassignment.model.BookDetails

/**
 * A simple [Fragment] subclass.
 */
class BookFragment : Fragment(R.layout.fragment_book) {

//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
//                              savedInstanceState: Bundle?): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_book, container, false)
//    }

    companion object {
        private val MESSAGE_DATA = "message_data"

        fun getInstance(list: ArrayList<BookDetails?>?): BookFragment {
            val bundle = Bundle()
            bundle.putParcelableArrayList(MESSAGE_DATA, list)
            val fragment = BookFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.book_rv)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val list = arguments?.getParcelableArrayList<BookDetails?>(MESSAGE_DATA)
        list?.apply { recyclerView.adapter = BookAdapter(context, list) }
    }

}
