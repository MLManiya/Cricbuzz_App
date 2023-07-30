package com.example.cricbuzz_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button teamGT,teamCSK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        teamGT = findViewById(R.id.activity_main_team1);
        teamCSK = findViewById(R.id.activity_main_team2);
        Intent intent = new Intent(MainActivity.this,Player_Detail_Activity.class);

        teamGT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("Team","GT");
                startActivity(intent);
            }
        });

        teamCSK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("Team","CSK");
                startActivity(intent);
            }
        });

    }
}