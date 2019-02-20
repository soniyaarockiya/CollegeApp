package com.example.a91user.collegeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.*;

public class ApplyConcession extends AppCompatActivity{

    DatabaseHelper db;

    EditText mTicketClass;
    EditText mTicketType;

    Button mButtonApply;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apply_concession);

        db = new DatabaseHelper(this);
        mTicketClass = findViewById(R.id.edittext_TicketClass);
        mTicketType = findViewById(R.id.edittext_TicketType);
        mButtonApply = findViewById(R.id.button_apply);

        mButtonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ticketClass = mTicketClass.getText().toString().trim();
                String ticketType = mTicketType.getText().toString().trim();

                long val= db.addUser(ticketClass,ticketType);

                if(val>0) {
                   Toast toast=  makeText(ApplyConcession.this, "Concession applied, please collect it within three days", LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                    toast.show();
                    Intent moveToNavigation = new Intent(ApplyConcession.this, NavigationActivity.class);
                    startActivity(moveToNavigation);
                }
                else{
                    Toast toast= makeText(ApplyConcession.this, "Application error", LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                    toast.show();



                }



            }
        });

    }
}
