package com.example.navigator.models;

import com.example.navigator.models.Pokemon;

import java.util.ArrayList;

public class PokemonRequest {

    private ArrayList<Pokemon> results;
    private String next;
    private String previous;

    public ArrayList<Pokemon> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }
}
