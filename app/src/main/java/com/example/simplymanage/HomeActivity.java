package com.example.simplymanage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HomeActivity extends AppCompatActivity {

    ImageButton imale, ifemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        imale = findViewById(R.id.i_mens);
        ifemale = findViewById(R.id.i_womens);

        imale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                male();
            }
        });

        ifemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                female();
            }
        });
    }

    public void male(){
        Intent intent = new Intent(getApplicationContext(), mens.class);
        startActivity(intent);
    }

    public void female(){
        Intent intent = new Intent(getApplicationContext(), womens.class);
        startActivity(intent);
    }
}