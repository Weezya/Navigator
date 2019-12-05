package com.example.navigator.views;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.navigator.R;

public class FeedbFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_feedb);
        getSupportActionBar().setTitle("Feedback");
    }
}
