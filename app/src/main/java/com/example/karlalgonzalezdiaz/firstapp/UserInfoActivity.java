package com.example.karlalgonzalezdiaz.firstapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class UserInfoActivity extends AppCompatActivity {

    public static final String GHOST_AWAY = "Ghost Away";
    public static final String NAME = "Name";
    public static final String EMAIL = "Email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText editTextName = (EditText) findViewById(R.id.edit_text_name);
        final EditText editTextEmail = (EditText) findViewById(R.id.edit_text_email);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                SharedPreferences sharedPreferences = getSharedPreferences(GHOST_AWAY, 0);
                sharedPreferences.edit().putString(NAME, editTextName.getText().toString()).apply();
                sharedPreferences.edit().putString(EMAIL, editTextEmail.getText().toString()).apply();
            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences(GHOST_AWAY, 0);


        Log.d("USER_INFO_ACTIVITY", "USER_INFO: "
                + sharedPreferences.getString(NAME, "") + ", "
                + sharedPreferences.getString(EMAIL,""));
    }

}
