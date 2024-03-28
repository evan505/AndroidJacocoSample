package com.androidjacoco.sample.main.view;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.androidjacoco.sample.R;
import com.androidjacoco.sample.main.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements IMainView {

    public static final String USERNAME_KEY = "username";

    MainPresenter presenter;
    TextView welcomeTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        welcomeTv = (TextView)findViewById(R.id.welcome_tv);

        presenter = new MainPresenter(this, getIntent().getStringExtra(USERNAME_KEY));
        presenter.showWelcome();
    }


    @Override
    public void showUserWelcome(String username) {
        welcomeTv.setText(username);
    }
}
