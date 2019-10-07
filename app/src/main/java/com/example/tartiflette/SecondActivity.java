package com.example.tartiflette;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class SecondActivity extends AppCompatActivity {

    TextView TvSigne;
    TextView TvDebut;
    TextView TvFin;
    TextView TvDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TvSigne=findViewById(R.id.Signe);
        TvDebut=findViewById(R.id.dateDebut);
        TvFin=findViewById(R.id.dateFin);
        TvDescription=findViewById(R.id.Description);


        Intent intent = getIntent();

        String Json_sunsign = getIntent().getStringExtra("sunsign_key"); //Récupère le paquet contenant toutes les informations concernant l'item en question
        Gson gson = new Gson();
        Sunsign sunsign = gson.fromJson(Json_sunsign, Sunsign.class); //Récupère les données passés en paramètre grâce à Sunsign.class

    //Affichage dans la deuxième page
    TvSigne.setText(sunsign.getSign());
    TvDebut.setText(sunsign.getBegin());
    TvFin.setText(sunsign.getEnd());
    TvDescription.setText(sunsign.getDescription());
    }

}
