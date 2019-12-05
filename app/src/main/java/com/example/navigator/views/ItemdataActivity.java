package com.example.navigator.views;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.navigator.R;

public class ItemdataActivity extends AppCompatActivity {

    TextView name;
    TextView desc;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemdata);

        getSupportActionBar().setTitle("Informations");

        name=findViewById(R.id.itemdataname);
        desc=findViewById(R.id.itemdatadesc);
        image=findViewById(R.id.itemdataimg);

        Intent intent = getIntent();

        name.setText(intent.getStringExtra("name"));
        desc.setText(intent.getStringExtra("desc"));
        image.setImageResource(intent.getIntExtra("image",0));
    }
}
