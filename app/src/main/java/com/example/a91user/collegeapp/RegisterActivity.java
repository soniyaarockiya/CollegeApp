package com.example.a91user.collegeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    DatabaseHelper db;

    EditText mTextNewUsername ;
    EditText mTextNewPassword;
    EditText mTextCnfPassword;
    Button mButtonRegister;
    TextView mTextViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);

        mTextNewUsername = findViewById(R.id.edittext_newName);
        mTextNewPassword= findViewById(R.id.edittext_newpassword);
        mTextCnfPassword= findViewById(R.id.edittext_confirmPassword);
        mButtonRegister =findViewById(R.id.button_register);
        mTextViewLogin= findViewById(R.id.textview_login);

        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(RegisterActivity.this,MainActivity.class );
                startActivity(loginIntent);
            }
        });

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextNewUsername.getText().toString().trim();
                String pwd = mTextNewPassword.getText().toString().trim();
                String cnf_pwd= mTextCnfPassword.getText().toString().trim();

                if(pwd.equals(cnf_pwd))
                {
                    Long val= db.addUser(user,pwd);

                    if(val>0) {
                        Toast.makeText(RegisterActivity.this, "Succesfully Registered", Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(moveToLogin);
                    }
                    else{
                        Toast.makeText(RegisterActivity.this, "Registration error", Toast.LENGTH_SHORT).show();

                    }

                }
                else
                {
                    Toast.makeText(RegisterActivity.this,"Login error", Toast.LENGTH_SHORT).show();

                }


            }
        });

    }
}
