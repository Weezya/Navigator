package com.example.navigator.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.navigator.R;
import com.example.navigator.controller.PokeapiService;
import com.example.navigator.controller.PokeAdapter;
import com.example.navigator.models.Pokemon;
import com.example.navigator.models.PokemonRequest;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokedexActivity extends AppCompatActivity {

    private static final String TAG = " POKEDEX: ";
    private Retrofit retrofit;

    private RecyclerView recyclerView;
    private PokeAdapter pokeAdapter;

    private int offset;
    private boolean readyToLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedex);

        //  =====   Toolbar setup

        Toolbar toolbar = findViewById(R.id.toolbardex);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" ");

        // === ===

        retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // === Recycler View ===

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        pokeAdapter = new PokeAdapter(this);
        recyclerView.setAdapter(pokeAdapter);
        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0){
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                    if(readyToLoad) {
                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                            Log.i(TAG, " All Pokemons uploaded.");

                            readyToLoad = false;
                            offset += 20;
                            fetchData(offset);
                        }
                    }
                }
            }
        });

        // specify an adapter (see also next example)
        //mAdapter = new MyAdapter(myDataset);
        //recyclerView.setAdapter(mAdapter);

        readyToLoad = true;
        offset = 0;
        fetchData(offset);
        }

    private void fetchData(int offset) {

        PokeapiService service = retrofit.create(PokeapiService.class);
        Call<PokemonRequest> pokemonRequestCall = service.obtainListPokemon(20,offset);

        pokemonRequestCall.enqueue(new Callback<PokemonRequest>() {
            @Override
            public void onResponse(Call<PokemonRequest> call, Response<PokemonRequest> response) {
                readyToLoad = true;
                if (response.isSuccessful()) {

                    PokemonRequest pokemonRequest = response.body();
                    ArrayList<Pokemon> listPokemon = pokemonRequest.getResults();

                    for (int i = 0; i < listPokemon.size(); i ++){
                        Pokemon p = listPokemon.get(i);
                        Log.i(TAG, " Pokemon: "+ p.getName());
                    }

                    pokeAdapter.moreListPokemon(listPokemon);

                } else {
                    Log.e(TAG, " onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<PokemonRequest> call, Throwable t) {
                readyToLoad = true;
                Log.e(TAG, " onFailure: " + t.getMessage());
            }
        });

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
        if (id == R.id.app_bar_search) {
            Snackbar.make(recyclerView, "Search (Work in progress)", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
