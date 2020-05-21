package com.dehaat.dehaatassignment.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
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
    private boolean isLandscape = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this, new MainRouter(this), this);
        presenter.fetchAuthors(listener);

        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            isLandscape = true;
        } else {
            isLandscape = false;
        }
    }

    private UpdateMainViewListener listener = new UpdateMainViewListener() {
        @Override
        public void updateView(@Nullable ArrayList<AuthorDetails> list) {

            // update recycler view
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            AuthorFragment fragment = AuthorFragment.Companion.getInstance(list, isLandscape);
            transaction.replace(R.id.frame_layout, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                presenter.onLogoutOptionClick();
        }
        return super.onOptionsItemSelected(item);
    }
}
