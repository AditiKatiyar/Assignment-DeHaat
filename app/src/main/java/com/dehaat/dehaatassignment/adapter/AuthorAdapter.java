package com.dehaat.dehaatassignment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.dehaat.dehaatassignment.R;
import com.dehaat.dehaatassignment.activity.ExpandableTextview;
import com.dehaat.dehaatassignment.fragment.BookFragment;
import com.dehaat.dehaatassignment.model.AuthorDetails;

import java.util.ArrayList;

public class AuthorAdapter extends RecyclerView.Adapter<AuthorAdapter.AuthorViewHolder> {

    private ArrayList<AuthorDetails> list;
    private Context context;
    private Boolean isLandscape;

    public AuthorAdapter(Context context, ArrayList<AuthorDetails> list, Boolean isLandscape) {
        this.context = context;
        this.list = list;
        this.isLandscape = isLandscape;
    }

    @NonNull
    @Override
    public AuthorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new AuthorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AuthorViewHolder holder, int position) {
        final AuthorDetails details = list.get(position);
        if (details != null) {
            holder.authorName.setText(details.getName());
            holder.authorBio.setText(details.getBio());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
                    BookFragment fragment = BookFragment.Companion.getInstance(details.getBooks());

                    if (isLandscape != null && isLandscape) {
                        transaction.replace(R.id.frame_layout_2, fragment);
                    } else {
                        transaction.replace(R.id.frame_layout, fragment);
                    }

                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class AuthorViewHolder extends RecyclerView.ViewHolder {
        TextView authorName;
        ExpandableTextview authorBio;

        public AuthorViewHolder(@NonNull View itemView) {
            super(itemView);
            authorName = itemView.findViewById(R.id.author_name);
            authorBio = itemView.findViewById(R.id.author_bio);
        }
    }
}
