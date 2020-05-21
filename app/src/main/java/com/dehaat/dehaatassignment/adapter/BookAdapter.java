package com.dehaat.dehaatassignment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dehaat.dehaatassignment.R;
import com.dehaat.dehaatassignment.model.BookDetails;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BooksViewHolder> {

    private Context context;
    private ArrayList<BookDetails> list;

    public BookAdapter(Context context, ArrayList<BookDetails> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public BooksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_book, parent, false);
        return new BooksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksViewHolder holder, int position) {
        BookDetails details = list.get(position);
        holder.bookName.setText(details.getTitle());
        holder.bookDetails.setText(details.getDescription());
        holder.publisher.setText(details.getPublisher());
        holder.publishedDate.setText(details.getPublishedDate());
        holder.price.setText(details.getPrice());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class BooksViewHolder extends RecyclerView.ViewHolder {
        TextView bookName;
        TextView bookDetails;
        TextView publisher;
        TextView publishedDate;
        TextView price;

        public BooksViewHolder(@NonNull View itemView) {
            super(itemView);

            bookName = itemView.findViewById(R.id.book_name);
            bookDetails = itemView.findViewById(R.id.book_details);
            publisher = itemView.findViewById(R.id.publisher);
            publishedDate = itemView.findViewById(R.id.published_date);
            price = itemView.findViewById(R.id.price);
        }
    }
}
