package com.example.navigator.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.navigator.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class ListActivity extends AppCompatActivity{

    ListView listView;

    String[] itemName = {
            "Sky",
            "Beach",
            "Bridge",
            "City",
            "Mountain",
            "Island"
            };

    String[] itemPlace = {
            "Far away",
            "Miami",
            "Portugal",
            "Los Angeles",
            "France",
            "Bahamas"
    };

    String[] itemDesc = {
            "(French)\n\nAdmirer les étoiles dans un espace loin de la ville et se griller quelques guimauves autour d'un feu",
            "(French)\n\nContourner la côte en passant par ce magnifique chemin digne de Vice City",
            "Vasco da Gama Bridge\n\n(French)\n\nMagnifique pont où l'on peut admirer le cours d'eau, conçu par les plus grands ingénieurs",
            "(French)\n\nAu cœur de la ville, avec ses flux et ses quartiers",
            "(French)\n\nUn endroit reculé caché entre des collines, idéal pour se ressourcer et se mettre au vert",
            "(French)\n\nVenir se baigner en famille ou avec ses amis et profiter du soleil pour s'amuser ou faire bronzette, sans oublier son maillot de bain"
            };

    int[] itemImg = {
            R.drawable.sky,
            R.drawable.beach,
            R.drawable.bridge,
            R.drawable.city,
            R.drawable.mountain,
            R.drawable.plage
            };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list);

        listView=findViewById(R.id.listview);
        MyFirstAdapter myadapter = new MyFirstAdapter();
        listView.setAdapter(myadapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ItemdataActivity.class);
                intent.putExtra("name", itemName[position]);
                intent.putExtra("place", itemPlace[position]);
                intent.putExtra("image", itemImg[position]);
                intent.putExtra("desc", itemDesc[position]);
                startActivity(intent);
                Toast.makeText(ListActivity.this,"Item information (Work in Progress)", Toast.LENGTH_SHORT).show();
            }
        });


        //  =====   Floating Button

        FloatingActionButton fab = findViewById(R.id.addbtn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "Add an item (Work in progress)", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private class MyFirstAdapter extends BaseAdapter {
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
            View view1 = getLayoutInflater().inflate(R.layout.list_item_row, null);

            TextView name = view1.findViewById(R.id.itemNameRow);
            ImageView image = view1.findViewById(R.id.itemImgRow);

            name.setText(itemName[position]);
            image.setImageResource(itemImg[position]);

            return view1;
        }
    }
}
