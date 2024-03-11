package com.example.valobank;


import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class LoginActivity extends AppCompatActivity {
    TextView bank_name;
    EditText username,password;
    FloatingActionButton fab;
    float v = 0;
    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tabLayout = findViewById(R.id.tab_layout);
        bank_name = findViewById(R.id.bank_name);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        fab = findViewById(R.id.fab_btn);

        tabLayout.addTab(tabLayout.newTab().setText("Login"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        username.setTranslationX(300);
        password.setTranslationX(300);
        fab.setTranslationX(300);
        bank_name.setTranslationX(300);
        tabLayout.setTranslationX(300);

        bank_name.setAlpha(v);
        tabLayout.setAlpha(v);
        username.setAlpha(v);
        password.setAlpha(v);
        fab.setAlpha(v);

        bank_name.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        tabLayout.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(100).start();
        username.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(300).start();
        password.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(500).start();
        fab.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(700).start();

        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);

    }

    public void Onclick (View v){

        if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
            //correct
            Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);

        } else if (username.getText().toString().equals("") && password.getText().toString().equals("admin")) {

            username.setError("Please input your username");
            username.requestFocus();

        } else if (username.getText().toString().equals("admin") && password.getText().toString().equals("")) {
            password.setError("Please input your password");
            password.requestFocus();


        } else if (username.getText().toString().equals("") && password.getText().toString().equals("")) {
            Toast.makeText(LoginActivity.this, "Username and password is required!", Toast.LENGTH_SHORT).show();

        } else if (!username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
            username.setError("User not found");
            username.requestFocus();

        } else if (username.getText().toString().equals("admin") && !password.getText().toString().equals("admin")) {
            password.setError("Incorrect Password");
            password.requestFocus();

        } else if (!username.getText().toString().equals("admin") && !password.getText().toString().equals("admin")) {
            Toast.makeText(LoginActivity.this, "Input valid credentials", Toast.LENGTH_SHORT).show();
        }
    }
}

