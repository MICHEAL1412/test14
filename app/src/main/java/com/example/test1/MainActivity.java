package com.example.test1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    LinearLayout Popular2,Coming_soon2,Now_showing2;

    private ViewFlipper viewFlipper;
    private DrawerLayout drawer;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    static final String STATE_FRAGMENT = "state_of_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer=findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FaqFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_faq);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new PolicyFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_policy);
        }
        int images[]={R.drawable.baba_yaga___terror_of_the_dark_forest,R.drawable.digimon_adventure___last_evolution_kizuna,R.drawable.candyman_2020,
                R.drawable.hitman___agent_jun,R.drawable.jumanji2,R.drawable.onward_};
        viewFlipper=findViewById(R.id.v_flipper);

        Popular2 = (LinearLayout)findViewById(R.id.Popular2);
        Coming_soon2 = (LinearLayout)findViewById(R.id.Coming_soon2);
        Now_showing2= (LinearLayout)findViewById(R.id.Now_showing2);

        ImageView imageView=new ImageView(this);


        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);

        viewFlipper.setInAnimation(this,android.R.anim.slide_in_left);
        viewFlipper.setInAnimation(this,android.R.anim.slide_out_right);


    }


    public void Pop(View view){
        Popular2.setVisibility(View.VISIBLE);
        Coming_soon2.setVisibility(View.GONE);
        Now_showing2.setVisibility(View.GONE);
    }
    public void coming(View view){
        Popular2.setVisibility(View.GONE);
        Coming_soon2 .setVisibility(View.VISIBLE);
        Now_showing2.setVisibility(View.GONE);
    }
    public void Now(View view){
        Popular2.setVisibility(View.GONE);
        Coming_soon2.setVisibility(View.GONE);
        Now_showing2.setVisibility(View.VISIBLE);
    }

    public void Rating(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, rating.class);
        startActivity(intent);

    }
    public void general(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, General.class);
        startActivity(intent);

    }
    public void FB(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, food_beverage.class);
        startActivity(intent);

    }
    public void feedback(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, Feedback.class);
        startActivity(intent);

    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
                break;
            case R.id.nav_faq:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FaqFragment()).commit();
                break;
            case R.id.nav_policy:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new PolicyFragment()).commit();
                break;
        }
        return false;
    }


   

}