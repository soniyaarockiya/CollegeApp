package com.example.a91user.collegeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    EditText mTextUsername ;
    EditText mTextPassword;
    Button mButtonLogin;
    TextView mTextViewRegister;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        mTextUsername = findViewById(R.id.edittext_username);
        mTextPassword= findViewById(R.id.edittext_password);
        mButtonLogin =findViewById(R.id.button_login);
        mTextViewRegister= findViewById(R.id.textview_register);

        mButtonLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                boolean res= db.Checkuser(user, pwd);
                if(res == true)
                {
                    Intent loginSuccess = new Intent(MainActivity.this, NavigationActivity.class);
                    startActivity(loginSuccess);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Login error", Toast.LENGTH_SHORT).show();

                }

            }
        });

        mTextViewRegister.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });







    }

}
