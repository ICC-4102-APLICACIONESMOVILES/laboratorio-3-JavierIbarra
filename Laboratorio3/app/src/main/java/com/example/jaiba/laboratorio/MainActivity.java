package com.example.jaiba.laboratorio;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.jaiba.laboratorio.dummy.DummyContent;
import com.example.jaiba.laboratorio.dummy.LatestFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, FormFragment.OnFragmentInteractionListener, ItemFragment.OnListFragmentInteractionListener, LatestFragment.OnFragmentInteractionListener {


    private Database db;
    private static final String DATABASE_NAME = "Forms";

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);

        if (preferences.getString("mail","")=="" || preferences.getString("password","")==""){
            Intent intent = new Intent(this,LoginActivity.class);
            startActivityForResult(intent,1);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //db = Room.databaseBuilder(getApplicationContext(), Database.class, DATABASE_NAME).fallbackToDesctructiveMigration().build();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        boolean FragmentTran = false;
        Fragment fragmento = null;

        if (id == R.id.nav_form) {
            fragmento = new FormFragment();
            FragmentTran=true;

        }
        else if (id == R.id.nav_gallery) {
            fragmento = new LatestFragment();
            FragmentTran=true;
        }
        else if (id == R.id.nav_list) {
            fragmento = new ItemFragment();
            FragmentTran=true;
        }
        else if (id == R.id.nav_logout) {
            SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
            SharedPreferences.Editor Obj_editor = preferences.edit();
            Obj_editor.putString("mail","");
            Obj_editor.putString("password","");
            Obj_editor.commit();

            Intent intent = new Intent(this,LoginActivity.class);
            startActivityForResult(intent,1);
        }

        if (FragmentTran){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main,fragmento).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
