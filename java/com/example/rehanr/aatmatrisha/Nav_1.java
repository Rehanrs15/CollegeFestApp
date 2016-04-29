package com.example.rehanr.aatmatrisha;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.ListView;
import android.widget.Toast;
public class Nav_1 extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private DrawerLayout drawerLayout;
    private ListView listView;
    private String[] planets;
    private ActionBarDrawerToggle drawerlistener;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_1);



        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        planets=getResources().getStringArray(R.array.nav_drawer_items);
        listView=(ListView)findViewById(R.id.drawerlist);
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,planets));
        listView.setOnItemClickListener(this);
        drawerlistener = new ActionBarDrawerToggle(this,drawerLayout,R.string.drawer_open,R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                Toast.makeText(Nav_1.this, "Drawer opened",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                Toast.makeText(Nav_1.this, "Drawer closed",Toast.LENGTH_SHORT).show();
            }
        };
        drawerLayout.setDrawerListener(drawerlistener);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerlistener.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerlistener.syncState();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, planets[position] + " was selected", Toast.LENGTH_LONG).show();
        selectItem(position);

        if(position==0){
            Intent i1 = new Intent(Nav_1.this,SignUp.class);
            startActivity(i1);
            finish();
        }
    }

    private void selectItem(int position) {

        listView.setItemChecked(position, true);
        setTitle(planets[position]);
    }

    public void setTitle(String title){
        getSupportActionBar().setTitle(title);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_nav_1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
