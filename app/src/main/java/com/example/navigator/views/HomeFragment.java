package com.example.navigator.views;

import android.content.Intent;
import android.os.Bundle;
import com.example.navigator.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class HomeFragment extends Fragment {

    ListView lst;

    String[] itemName = {
            "Étoiles",
            "Rocade",
            "Viaduc",
            "Métropole",
            "Collines",
            "Plage"
    };

    String[] itemDesc = {
            "Admirer les étoiles dans un espace loin de la ville et se griller quelques guimauves autour d'un feu",
            "Magnifique pont où l'on peut admirer le cours d'eau, conçu par les plus grands ingénieurs",
            "Contourner la côte en passant par ce magnifique chemin digne de Vice City",
            "Au cœur de la ville, avec ses flux et ses quartiers",
            "Un endroit reculé caché entre des collines, idéal pour se ressourcer et se mettre au vert",
            "Venir se baigner en famille ou avec ses amis et profiter du soleil pour s'amuser ou faire bronzette, sans oublier son maillot de bain"
    };

    int[] itemImg = {
            R.drawable.sky,
            R.drawable.beach,
            R.drawable.bridge,
            R.drawable.city,
            R.drawable.mountain,
            R.drawable.plage
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {

        View inflate = inflater.inflate(R.layout.fragment_home,container, false);

        return inflate;
    }
}
