package com.example.myapplication.V.Activity;

import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.myapplication.M.DataType.Counter;
import com.example.myapplication.R;
import com.example.myapplication.V.ConnectGraphview;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.Set;

public class SingleRootActivity extends AppCompatActivity {


    ListView listView;
    Set<BluetoothDevice> pared;
    Dialog dialog;
    TextView textplay;
    ImageView notch;
    GraphView graphView;
    Button line,btn,montage,bluetooth,play,choose_channel;
    float s1[]=new float[65000];

    int notchcount;
    int playcount;
    int text_play=0;

    float d=2;

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleroot);
        Vibrator vibrator= (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);




        notchcount=0;
        playcount=0;
        dialog=new Dialog(SingleRootActivity.this);
        dialog.setContentView(R.layout.bluetooth_alert);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        FindViewById();

     listView=dialog.findViewById(R.id.list);

        textplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.vibrate(40);
                if (text_play==0){
                    textplay.setText("×2");
                    text_play=1;

                }
                else if (text_play==1){
                    textplay.setText("×0.5");
                    text_play=2;

                }
                else if (text_play==2){
                    textplay.setText("×1");
                    text_play=0;

                }


            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                  if(playcount==0) {
                      play.setBackgroundResource(R.drawable.pause_root_foreground);
                      playcount=1;
                  }
                  else if(playcount==1) {
                      play.setBackgroundResource(R.drawable.play_foreground);
                      playcount=0;


              }
            }
        });


        montage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(SingleRootActivity.this,montage);
                popup.getMenuInflater().inflate(R.menu.montage, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        montage.setText(menuItem.getTitle());

                        return true;
                    }
                });
                popup.show();


            }
        });
        notch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(notchcount==0) {
                    notch.setBackgroundResource(R.mipmap.notch_);
                    notchcount=1;
                }
                else if(notchcount==1) {
                    notch.setBackgroundResource(R.mipmap.notch_off_);
                    notchcount=0;

                }
            }
        });
        line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),EightRootActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();

            }
        });

        DrawerLayout drawerLayout=findViewById(R.id.draver_singleroot);

        btn.setOnClickListener(view -> drawerLayout.openDrawer(GravityCompat.START));

        choose_channel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(SingleRootActivity.this,choose_channel);
                popup.getMenuInflater().inflate(R.menu.montage, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        choose_channel.setText(menuItem.getTitle());

                        return true;
                    }
                });
                popup.show();

            }
        });
//////////////////////////////////////////////////////////////////////////////////////////////


        graphView=findViewById(R.id.singlegraphview);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{

                new DataPoint(0, 1),
                new DataPoint(1, 3),
                new DataPoint(2, 4),
                new DataPoint(3, 9),
                new DataPoint(4, 6),
                new DataPoint(5, 3),
                new DataPoint(6, 6),
                new DataPoint(7, 1),
                new DataPoint(8, 2)
        });


        graphView.addSeries(series);

        // Log.e("333","111111111111");



///////////////////////////////////////////////////////////////////////////////////////////////////




    }

    private void FindViewById() {

        line=findViewById(R.id.line_singleroot);
        play=findViewById(R.id.plsy_singleroot);
        btn=findViewById(R.id.note_singleroot);
        textplay=findViewById(R.id.singletextplay);
        notch=findViewById(R.id.notch_singleroot);
        montage=findViewById(R.id.montage_singleroot);
        choose_channel=findViewById(R.id.choiosechannel);
    }
}
