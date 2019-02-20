package com.example.a91user.collegeapp;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



public class NavigationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle ;

    RecyclerView recyclerView;
    ProductAdapter adapter;
    List<Product> productList;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        NavigationView navigationView =(NavigationView) findViewById(R.id.navigationview);
        navigationView.setNavigationItemSelectedListener(this);


        mDrawerLayout = findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout, R.string.Open, R.string.Close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


            productList = new ArrayList<>();

            productList.add(new Product(R.drawable.recycler1, "Yo bitches", "Hell yeah it works !!!"));

            productList.add(new Product(R.drawable.recycler2, "Yo bitches", "Hell yeah it works !!!"));

         productList.add(new Product(R.drawable.recycler3, "Yo bitches", "Hell yeah it works !!!"));



        ProductAdapter adapter = new ProductAdapter(this, productList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)){
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id = menuItem.getItemId();


           switch(id){

                case R.id.home:
                    Intent HomeIntent = new Intent(this,NavigationActivity.class);
                    startActivity(HomeIntent);
                    break;

                case R.id.concession:
                    Intent ConcessionIntent =new Intent(NavigationActivity.this, ApplyConcession.class);
                    startActivity(ConcessionIntent);

                    break;
            }


        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
