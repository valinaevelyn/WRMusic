package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.myapplication.Fragments.AboutFragment;
import com.example.myapplication.Fragments.ItemFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public DrawerLayout drawerLayout;
    public NavigationView drawerView;
    public ImageButton drawerOpenButton;
    public ImageButton drawerCloseButton;
    private TextView drawerUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        drawerView = findViewById(R.id.drawer_view);
        drawerOpenButton = findViewById(R.id.drawer_open_button);

        View headerView = drawerView.getHeaderView(0);
        drawerUsername = headerView.findViewById(R.id.drawer_username);

        Intent intent = getIntent();
        String username = intent.getStringExtra("USERNAME");

        drawerUsername.setText(username);

        drawerView.setNavigationItemSelectedListener(this);

//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this,
//                drawerLayout,
//                R.string.drawer_nav_open,
//                R.string.drawer_nav_close
//        );
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();

        drawerOpenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        if (savedInstanceState == null){
//            Ini yang nanti diubah jadi home
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutFragment()).commit();
            drawerView.setCheckedItem(R.id.nav_about);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.nav_home){
            // home fragment
        } else if(item.getItemId() == R.id.nav_about){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutFragment()).commit();
        } else if(item.getItemId() == R.id.nav_items_list){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ItemFragment()).commit();
        } else if(item.getItemId() == R.id.nav_logout){
            // login page
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }

        item.setChecked(true);

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}