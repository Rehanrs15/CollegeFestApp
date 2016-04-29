package com.example.rehanr.aatmatrisha;

import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Technical_Drawer extends AppCompatActivity implements AdapterView.OnItemClickListener{


    private DrawerLayout drawerLayout;
    private ListView listview;
    private String[] planets;
    private ActionBarDrawerToggle drawerListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technical__drawer);

        planets = getResources().getStringArray(R.array.nav_drawer_items);
        listview = (ListView)findViewById(R.id.drawerlist);
       // listview.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, planets));
        listview.setOnItemClickListener(this);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawerlayout);
        drawerListener = new ActionBarDrawerToggle(this,drawerLayout,R.string.drawer_open,R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                Toast.makeText(Technical_Drawer.this,"Drawer opened",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                Toast.makeText(Technical_Drawer.this,"Drawer Closed",Toast.LENGTH_SHORT).show();
            }
        };
        drawerLayout.setDrawerListener(drawerListener);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(drawerListener.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
//for screen change or orientation change
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerListener.onConfigurationChanged(newConfig);
    }

    //3 lines come here
    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        drawerListener.syncState();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,planets[position]+" was selected",Toast.LENGTH_LONG).show();
        selectItem(position);
    }

    public void selectItem(int position){

        listview.setItemChecked(position, true);
        setTitle(planets[position]);
    }

    public void setTitle(String title){
        getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

}
