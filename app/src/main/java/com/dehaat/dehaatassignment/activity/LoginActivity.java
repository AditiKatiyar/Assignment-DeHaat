package com.dehaat.dehaatassignment.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dehaat.dehaatassignment.R;
import com.dehaat.dehaatassignment.presenter.ILoginPresenter;
import com.dehaat.dehaatassignment.presenter.LoginPresenter;
import com.dehaat.dehaatassignment.router.LoginRouter;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, ILoginView {

    EditText email;
    EditText password;
    Button loginButton;
    ILoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.login_button);

        presenter = new LoginPresenter(this, new LoginRouter(this), this);

        loginButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_button:
                String userEmail = email.getText().toString();
                String userPassword = password.getText().toString();
                presenter.onLoginButtonClick(userEmail, userPassword);
        }
    }
}
