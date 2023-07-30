package com.example.cricbuzz_app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Myadapter extends BaseAdapter {
    Player_Detail_Activity player_detail_activity;
    int[] imgArrGT;
    int[] imgArrCSK;

    String[] playerNameGT;
    String[] playerNameCSK;
  //  String[] playerNameCSK;

    public Myadapter(Player_Detail_Activity player_detail_activity, int[] imgArr, String[] playerName) {
        this.player_detail_activity = player_detail_activity;
        this.imgArrGT = imgArr;
        this.imgArrCSK = imgArr;
        this.playerNameGT = playerName;
        this.playerNameCSK = playerName;
    }
   /* public Myadapter(Player_Detail_Activity player_detail_activity,int[] imgArrCSK, String[] playerNameCSK){
        this.player_detail_activity = player_detail_activity;
        this.imgArrCSK = imgArrCSK;
        this.playerNameCSK = playerNameCSK;
    }*/

    @Override
    public int getCount() {
        return playerNameGT.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(player_detail_activity).inflate(R.layout.activity_detail_listview_item_file,viewGroup,false);
        ImageView playerimage = view.findViewById(R.id.activity_main_team_item_imageview);
        TextView playername = view.findViewById(R.id.activity_main_team_item_playername);
      //  TextView playerdetail = view.findViewById(R.id.activity_main_team_gt_item_playerdetail);

        playerimage.setImageResource(imgArrGT[i]);
        playerimage.setImageResource(imgArrCSK[i]);
        playername.setText(playerNameGT[i]);
        playername.setText(playerNameCSK[i]);

        Intent intent = new Intent(player_detail_activity,Player_Info_Page.class);

       /* playerimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder();
                intent.putExtra("sign",1);
                intent.putExtra("playerImageGT",imgArrGT[i]);
                player_detail_activity.startActivity(intent);
            }
        });
        playerimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("sign",2);
                intent.putExtra("playerImageCSK",imgArrCSK[i]);
                player_detail_activity.startActivity(intent);
            }
        });*/
        playerimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(player_detail_activity);
                builder.setTitle("!...Alert...!");
                builder.setMessage("Are You Sure To Show The Image!");
                builder.setPositiveButton("Open", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        intent.putExtra("sign",1);
                        intent.putExtra("playerImageGT",imgArrGT[i]);
                        player_detail_activity.startActivity(intent);
                        intent.putExtra("sign",2);
                        intent.putExtra("playerImageCSK",imgArrCSK[i]);
                        player_detail_activity.startActivity(intent);
                    }
                });
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });
        return view;
    }
}
