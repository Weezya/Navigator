package com.example.navigator.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.navigator.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ListView listView;

    String[] itemName = {
            "Métropole",
            "Rocade",
            "Collines",
            "Viaduc",
            "Plage",
            "Étoiles"};

    String[] itemDesc = {
            "Au cœur de la ville, avec ses flux et ses quartiers",
            "Contourner la côte en passant par ce magnifique chemin digne de Vice City",
            "Un endroit reculé caché entre des collines, idéal pour se ressourcer et se mettre au vert",
            "Magnifique pont où l'on peut admirer le cours d'eau, conçu par les plus grands ingénieurs",
            "Venir se baigner en famille ou avec ses amis et profiter du soleil pour s'amuser ou faire bronzette, sans oublier son maillot de bain",
            "Admirer les étoiles dans un espace loin de la ville et se griller quelques guimauves autour d'un feu"};

    int[] itemImg = {
            R.drawable.city,
            R.drawable.beach,
            R.drawable.mountain,
            R.drawable.bridge,
            R.drawable.plage,
            R.drawable.sky};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Navigator Beta by Loan");
        listView=findViewById(R.id.listviewshow);
        MyAdapter myadapter = new MyAdapter();
        listView.setAdapter(myadapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ItemdataActivity.class);
                intent.putExtra("name", itemName[position]);
                intent.putExtra("image", itemImg[position]);
                intent.putExtra("desc", itemDesc[position]);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"Work in Progress", Toast.LENGTH_SHORT).show();
            }
        });


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_prof) {
            startActivity(new Intent(MainActivity.this, ProfilActivity.class));
        } else if (id == R.id.nav_resa) {
            startActivity(new Intent(MainActivity.this, ResaActivity.class));
        } else if (id == R.id.nav_feedb) {
            startActivity(new Intent(MainActivity.this, FeedbActivity.class));
        } else if (id == R.id.nav_param) {
            startActivity(new Intent(MainActivity.this, ParamActivity.class));
        } else if (id == R.id.nav_help) {
            startActivity(new Intent(MainActivity.this, HelpActivity.class));
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return itemImg.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view1 = getLayoutInflater().inflate(R.layout.item_row_data,null);

            TextView name = view1.findViewById(R.id.itemNameRow);
            TextView desc = view1.findViewById(R.id.itemDescRow);
            ImageView image = view1.findViewById(R.id.itemImgRow);

            name.setText(itemName[position]);
            desc.setText(itemDesc[position]);
            image.setImageResource(itemImg[position]);

            return view1;
        }
    }
}
