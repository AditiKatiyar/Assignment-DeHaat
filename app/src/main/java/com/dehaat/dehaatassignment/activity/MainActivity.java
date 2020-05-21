package com.dehaat.dehaatassignment.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.dehaat.dehaatassignment.R;
import com.dehaat.dehaatassignment.fragment.AuthorFragment;
import com.dehaat.dehaatassignment.listeners.UpdateMainViewListener;
import com.dehaat.dehaatassignment.model.AuthorDetails;
import com.dehaat.dehaatassignment.presenter.IMainPresenter;
import com.dehaat.dehaatassignment.presenter.MainPresenter;
import com.dehaat.dehaatassignment.router.MainRouter;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IMainView {

    private IMainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this, new MainRouter(this), this);
        presenter.fetchAuthors(listener);
    }

    private UpdateMainViewListener listener = new UpdateMainViewListener() {
        @Override
        public void updateView(@Nullable ArrayList<AuthorDetails> list) {

            // update recycler view
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            AuthorFragment fragment = AuthorFragment.Companion.getInstance(list);
            transaction.replace(R.id.frame_layout, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    };


}
