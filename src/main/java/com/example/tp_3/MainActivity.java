package com.example.tp_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    EditText editnom, editprenom, editdprt;
    Button btnsave;
    ListView lview;
    ArrayList<String> arrlist;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Links

        editnom = (EditText) findViewById(R.id.editnom);
        editprenom = (EditText) findViewById(R.id.editprenom);
        editdprt = (EditText) findViewById(R.id.editdprt);
        btnsave = (Button) findViewById(R.id.btnsave);
        lview = (ListView) findViewById(R.id.lview);


        arrlist = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrlist);
        lview.setAdapter(adapter);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Events

        btnClick();
    }


    // Click handling
    public void btnClick() {
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nom = editnom.getText().toString();
                String prenom = editprenom.getText().toString();
                String dprt = editdprt.getText().toString();
                String sexe = "";
                RadioGroup rgrp = (RadioGroup) findViewById(R.id.rsexe);

                switch (rgrp.getCheckedRadioButtonId()) {
                    case R.id.radioh:
                        sexe = "Homme";
                        break;
                    case R.id.radiof:
                        sexe = "Femme";
                        break;
                    default:
                        sexe = "Homme";
                        break;
                }
                if(nom != "" && prenom != "" && dprt != ""){
                    arrlist.add(nom + " " + prenom + " " + sexe + " " + dprt);
                    adapter.notifyDataSetChanged();
                }
                else {
                    Toast.makeText(MainActivity.this, "Veuillez saisir les données", Toast.LENGTH_SHORT).show();
                }



            }
        });
    }
}