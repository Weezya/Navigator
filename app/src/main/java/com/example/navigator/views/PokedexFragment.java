package com.example.navigator.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.navigator.R;
import com.example.navigator.controller.PokeapiService;
import com.example.navigator.controller.ListPokeAdapter;
import com.example.navigator.models.Pokemon;
import com.example.navigator.models.PokemonRequest;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokedexFragment extends AppCompatActivity {

    private static final String TAG = " POKEDEX: ";
    private Retrofit retrofit;

    private RecyclerView recyclerView;
    private ListPokeAdapter listPokeAdapter;

    private int offset;
    private boolean readyToLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_pokedex);

        getSupportActionBar().setTitle("Pokedex");

        // === ===

        retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // === Recycler View ===

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        listPokeAdapter = new ListPokeAdapter(this);
        recyclerView.setAdapter(listPokeAdapter);
        // OK
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a grid layout manager
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        // use a linear layout manager
        // layoutManager = new LinearLayoutManager(this);
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
                            obtainData(offset);
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
        obtainData(offset);
        }

    private void obtainData(int offset) {

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

                    listPokeAdapter.moreListPokemon(listPokemon);

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
}
