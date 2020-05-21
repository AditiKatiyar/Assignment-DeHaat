package com.dehaat.dehaatassignment.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.dehaat.dehaatassignment.R;
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

        }
    };
}
