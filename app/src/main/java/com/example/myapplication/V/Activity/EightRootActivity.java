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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.myapplication.M.DataType.Counter;
import com.example.myapplication.M.DataType.String1;
import com.example.myapplication.P.FileReader;
import com.example.myapplication.P.SetPivotName;
import com.example.myapplication.P.SetPivotValue;
import com.example.myapplication.R;
import com.example.myapplication.V.ConnectGraphview;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Set;

public class EightRootActivity extends AppCompatActivity {
    Button line,btn,bluetooth,montage,play;
    ImageView notch;
    TextView textplay;
    ListView listView;
    BluetoothAdapter bluetoothAdapter;
    Set<BluetoothDevice> pared;
    Dialog dialog;

    SetPivotName namePivote;
    SetPivotValue pivotValue;

    String1 string1;
    Counter counter;
    BufferedReader myReader;
    int g=0;

    int text_play=0;
    int notchcount;
    GraphView graphView1,graphView2,graphView3,graphView4,graphView5,graphView6,graphView7,graphView8,graphView9;
    int playcount;
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
        setContentView(R.layout.eightroot);
        LinearLayout linearLayout=findViewById(R.id.left_linearlayout);

        Vibrator vibrator= (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        notchcount=0;
        playcount=0;
        string1=new String1();
        counter=new Counter();
        dialog=new Dialog(EightRootActivity.this);
        dialog.setContentView(R.layout.bluetooth_alert);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        FindViewById();



        IntentFilter scanintentFilter=new IntentFilter(BluetoothAdapter.ACTION_SCAN_MODE_CHANGED);
        BroadcastReceiver scanmodereceiver=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action=intent.getAction();
                if(action.equals(BluetoothAdapter.ACTION_SCAN_MODE_CHANGED))
                {
                    int modevalue = intent.getIntExtra(BluetoothAdapter.EXTRA_SCAN_MODE,BluetoothAdapter.ERROR);
                    if (modevalue==BluetoothAdapter.SCAN_MODE_CONNECTABLE){
                        bluetooth.setBackgroundResource(R.drawable.bluetooth_on_foreground);

                    }else if (modevalue==BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE)
                    {

                    }else if (modevalue==BluetoothAdapter.SCAN_MODE_NONE)
                    {
                        bluetooth.setBackgroundResource(R.drawable.bluetooth_off_foreground);


                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                    }
                }

            }
        };
        registerReceiver(scanmodereceiver,scanintentFilter);


        bluetoothAdapter= BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter==null){
            Toast.makeText(getApplicationContext(),"null",Toast.LENGTH_LONG).show();
            finish();
        }
        if (bluetoothAdapter.isEnabled()){
        }
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
        bluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bluetooth.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        pared=bluetoothAdapter.getBondedDevices();
                        ArrayList list=new ArrayList();
                        for (BluetoothDevice bt:pared){
                            list.add(bt.getName());

                        }
                        ArrayAdapter adapter=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,list);
                        listView.setAdapter(adapter);
                        dialog.show();
                    }
                });

            }
        });
        montage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(EightRootActivity.this,montage);
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
                Intent intent=new Intent(getApplicationContext(),SingleRootActivity.class);

                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();

            }
        });
        DrawerLayout drawerLayout=findViewById(R.id.draver_eightroot);
        btn.setOnClickListener(view -> drawerLayout.openDrawer(GravityCompat.START));
    /////////////////////////////////////////////////////////////////////////////////////////////
        graphView1 = findViewById(R.id.eightgraphview1);

        LineGraphSeries<DataPoint> series1 = new LineGraphSeries<DataPoint>(new DataPoint[]{


                new DataPoint(0, 3),
                new DataPoint(1, 5),
                new DataPoint(2, 6),
                new DataPoint(3, 11),
                new DataPoint(4, 8),
                new DataPoint(5, 5),
                new DataPoint(6, 8),
                new DataPoint(7, 3),
                new DataPoint(8, 4)
        });
        //// graphView.setTitleTextSize(9);

        graphView1.getGridLabelRenderer().setVerticalLabelsVisible(false);
        graphView1.getGridLabelRenderer().setGridStyle( GridLabelRenderer.GridStyle.VERTICAL);
        graphView1.getViewport().setDrawBorder(true);

       // graphView1.getGridLabelRenderer().setHorizontalLabelsVisible(false);
        graphView1.addSeries(series1);

        series1.setColor(Color.MAGENTA);
        graphView1.getGridLabelRenderer().setTextSize(15);



        series1.setDrawBackground(false);

////////////////////////////////////////////////////////////////////////////////////////


        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<DataPoint>(new DataPoint[]{

                new DataPoint(0, 5),
                new DataPoint(1, 7),
                new DataPoint(2, 8),
                new DataPoint(3, 13),
                new DataPoint(4, 10),
                new DataPoint(5, 7),
                new DataPoint(6, 10),
                new DataPoint(7, 5),
                new DataPoint(8, 6)
        });
        //// graphView.setTitleTextSize(9);
        graphView1.addSeries(series2);

        series2.setColor(Color.GREEN);

        series2.setDrawBackground(false);

////////////////////////////////////////////////////////////////////////////////////////

        LineGraphSeries<DataPoint> series3 = new LineGraphSeries<DataPoint>(new DataPoint[]{

                new DataPoint(0, 7),
                new DataPoint(1, 9),
                new DataPoint(2, 10),
                new DataPoint(3, 15),
                new DataPoint(4, 12),
                new DataPoint(5, 9),
                new DataPoint(6, 12),
                new DataPoint(7, 7),
                new DataPoint(8, 8)
        });
        //// graphView.setTitleTextSize(9);


        graphView1.addSeries(series3);

        series3.setColor(Color.YELLOW);

        series3.setDrawBackground(false);

////////////////////////////////////////////////////////////////////////////////////////

        LineGraphSeries<DataPoint> series4 = new LineGraphSeries<DataPoint>(new DataPoint[]{

                new DataPoint(0, 9),
                new DataPoint(1, 11),
                new DataPoint(2, 12),
                new DataPoint(3, 17),
                new DataPoint(4, 14),
                new DataPoint(5, 11),
                new DataPoint(6, 14),
                new DataPoint(7, 9),
                new DataPoint(8, 10)
        });
        //// graphView.setTitleTextSize(9);

        graphView1.addSeries(series4);

        series4.setColor(Color.BLUE);

        series4.setDrawBackground(false);

////////////////////////////////////////////////////////////////////////////////////////


        LineGraphSeries<DataPoint> series5 = new LineGraphSeries<DataPoint>(new DataPoint[]{

                new DataPoint(0, 13),
                new DataPoint(1, 15),
                new DataPoint(2, 16),
                new DataPoint(3, 21),
                new DataPoint(4, 18),
                new DataPoint(5, 15),
                new DataPoint(6, 18),
                new DataPoint(7, 13),
                new DataPoint(8, 14)
        });
        //// graphView.setTitleTextSize(9);



        graphView1.addSeries(series5);
        series5.setColor(Color.MAGENTA);

        series5.setDrawBackground(false);

////////////////////////////////////////////////////////////////////////////////////////

        LineGraphSeries<DataPoint> series6 = new LineGraphSeries<DataPoint>(new DataPoint[]{

                new DataPoint(0, 16),
                new DataPoint(1, 18),
                new DataPoint(2, 19),
                new DataPoint(3, 24),
                new DataPoint(4, 21),
                new DataPoint(5, 18),
                new DataPoint(6, 21),
                new DataPoint(7, 16),
                new DataPoint(8, 17)
        });
        //// graphView.setTitleTextSize(9);


        graphView1.addSeries(series6);

        series6.setColor(Color.GREEN);
        series6.setDrawBackground(false);

////////////////////////////////////////////////////////////////////////////////////////

        LineGraphSeries<DataPoint> series7 = new LineGraphSeries<DataPoint>(new DataPoint[]{

                new DataPoint(0, 21),
                new DataPoint(1, 23),
                new DataPoint(2, 24),
                new DataPoint(3, 29),
                new DataPoint(4, 26),
                new DataPoint(5, 23),
                new DataPoint(6, 26),
                new DataPoint(7, 21),
                new DataPoint(8, 22)
        });
        //// graphView.setTitleTextSize(9);


        graphView1.addSeries(series7);
        series7.setColor(Color.YELLOW);
        series7.setDrawBackground(false);

////////////////////////////////////////////////////////////////////////////////////////

        LineGraphSeries<DataPoint> series8 = new LineGraphSeries<DataPoint>(new DataPoint[]{

                new DataPoint(0, 26),
                new DataPoint(1, 28),
                new DataPoint(2, 29),
                new DataPoint(3, 34),
                new DataPoint(4, 31),
                new DataPoint(5, 28),
                new DataPoint(6, 31),
                new DataPoint(7, 26),
                new DataPoint(8, 27)
        });



        graphView1.addSeries(series8);
        series8.setColor(Color.BLUE);
        series8.setDrawBackground(false);

////////////////////////////////////////////////////////////////////////////////////////////////
/*
        graphView9 = findViewById(R.id.eightgraphview9);

        LineGraphSeries<DataPoint> series9 = new LineGraphSeries<DataPoint>(new DataPoint[]{});


        graphView9.getGridLabelRenderer().setVerticalLabelsVisible(false);
        graphView9.getGridLabelRenderer().setGridStyle( GridLabelRenderer.GridStyle.HORIZONTAL);
        graphView9.addSeries(series8);



        series9.setColor(Color.BLUE);
        series9.setDrawBackground(false);




 */
////////////////////////////////////////////////////////////////////////////////////////

        graphView1.removeAllSeries();
        ConnectGraphview drawGraphview=new ConnectGraphview(graphView1,counter);
        drawGraphview.draw();
    }




    private void FindViewById() {
        line=findViewById(R.id.line_eightroot);
        textplay=findViewById(R.id.eighttextplay);
        play=findViewById(R.id.plsy_eightroot);
        btn=findViewById(R.id.note_eightroot);
        notch=findViewById(R.id.notch_eightroot);
        montage=findViewById(R.id.montage_eightroot);
        bluetooth=findViewById(R.id.bluetoooth_eightroot);
        listView=dialog.findViewById(R.id.list);
    }
}
