package com.example.cricbuzz_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Player_Info_Page extends AppCompatActivity {
    ImageView imageView;
    TextView playername;
    String team;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_info_page);
        imageView = findViewById(R.id.activity_main_team_item_imageview);
        playername = findViewById(R.id.activity_main_team_item_playername);

        int pos = getIntent().getIntExtra("Position",0);
        System.out.println("Pos"+pos);

        int sign = getIntent().getIntExtra("sign",0);
        System.out.println("Sign"+sign);

        team=getIntent().getStringExtra("teamplayer");
        if(team.equals("GT")) {
            if(sign==1) {

                int playerImageGT = getIntent().getIntExtra("playerImageGT",0);
                imageView.setImageResource(playerImageGT);
            }
            else {
                int[] ImgArrGT = getIntent().getIntArrayExtra("ImageGT");
                String[] PlayerNameGT = getIntent().getStringArrayExtra("PlayerNameGT");
                playername.setText(""+PlayerNameGT[pos]);
                imageView.setImageResource(ImgArrGT[pos]);
            }
        }
        else if (team.equals("CSK")) {
            if(sign==2)
            {
                int playerImageCSK = getIntent().getIntExtra("playerImageCSK",0);
                imageView.setImageResource(playerImageCSK);
            }
            else {
                int[] ImgArrCSK = getIntent().getIntArrayExtra("ImageCSK");
                String[] PlayerNameCSK = getIntent().getStringArrayExtra("PlayerNameCSK");
                imageView.setImageResource(ImgArrCSK[pos]);
                playername.setText(""+PlayerNameCSK[pos]);
            }
        }
    }
}