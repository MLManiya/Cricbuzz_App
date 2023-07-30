package com.example.cricbuzz_app;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class Player_Detail_Activity extends AppCompatActivity {
    Toolbar toolbar;
    GridView gridView;
    ImageView imageView;
    int[] ImgArrGT = {R.drawable.gt_1,R.drawable.gt_2,R.drawable.gt_3,R.drawable.gt_4,R.drawable.gt_5};
    int[] ImgArrCSK = {R.drawable.csk_1,R.drawable.csk_2,R.drawable.csk_3,R.drawable.csk_4,R.drawable.csk_5};
    String[] PlayerNameGT = {"David Miller","SHUBMAN GILL","MATTHEW WADE","WRIDDHIMAN SAHA","KANE WILLIAMSON"};
    String[] PlayerNameCSK = {"MS DHONI","DEVON CONWAY"," RUTURAJ GAIKWAD","SUBHRANSHU SENAPATI","AMBATI RAYUDU"};
    Myadapter adpater;// = new Myadapter(Player_Detail_Activity.this,ImgArrCSK,PlayerNameCSK);
    String team;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_listview);
        gridView = findViewById(R.id.activity_main_listview_team_player);
        toolbar = findViewById(R.id.toolbar);

       // imageView = findViewById(R.id.activity_main_team_item_imageview);
        team=getIntent().getStringExtra("Team");
        if(team.equals("GT"))
        {
            adpater = new Myadapter(Player_Detail_Activity.this,ImgArrGT,PlayerNameGT);
            gridView.setAdapter(adpater);
           // imageView.setImageResource(ImgArrGT[i]);
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    Intent intent = new Intent(Player_Detail_Activity.this,Player_Info_Page.class);
                    intent.putExtra("Position",i);
                    intent.putExtra("ImageGT",ImgArrGT);
                    intent.putExtra("PlayerNameGT",PlayerNameGT);
                    intent.putExtra("teamplayer","GT");
                    startActivity(intent);
                    setSupportActionBar(toolbar);
                    if(getSupportActionBar()!=null)
                    {
                        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                    }
                    toolbar.setTitle("My Toolbar");
                    toolbar.setSubtitle("Sub Title");
                }
            });
        } else if (team.equals("CSK"))
        {
            adpater = new Myadapter(Player_Detail_Activity.this,ImgArrCSK,PlayerNameCSK);
            gridView.setAdapter(adpater);
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(Player_Detail_Activity.this,Player_Info_Page.class);
                intent.putExtra("Position",i);
                intent.putExtra("ImageCSK",ImgArrCSK);
                intent.putExtra("PlayerNameCSK",PlayerNameCSK);
                intent.putExtra("teamplayer","CSK");
                startActivity(intent);
            }
        });
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemid = item.getItemId();
        if(itemid==R.id.main_menu_rating)
        {
            Toast.makeText(this,"Rate The App",Toast.LENGTH_SHORT);
        } else if (itemid==R.id.main_menu_feedback) {
            Toast.makeText(this,"Feedback",Toast.LENGTH_SHORT);
        } else if (itemid==R.id.main_menu_setting) {
            Toast.makeText(this,"Setting",Toast.LENGTH_SHORT);
        } else if (itemid==R.id.main_menu_about) {
            Toast.makeText(this,"About",Toast.LENGTH_SHORT);
        } else {
            Toast.makeText(this,"TEam Show",Toast.LENGTH_SHORT);
        }
        return super.onOptionsItemSelected(item);
    }
}