package com.example.myapplication.V;

import android.util.Log;

import com.example.myapplication.M.DataType.Counter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class DrawGraphView {
float count=0;
int channel_count;

    public DrawGraphView(int channel_count) {
        this.channel_count = channel_count;
    }

    void draw(int i, Counter counter, GraphView graphView){


        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>();
        for (int j=0;j<8000;j+=6) {
            series.appendData(new DataPoint(j,  counter.getAll(j)+count), false, 9000);
            counter.getChannel(i, j);


        }


        graphView.getViewport().setMaxX(4000);
        graphView.getViewport().setMinX(0);

        graphView.getViewport().setMaxY(channel_count*100);
        Log.e("[[[[",""+channel_count*100);

        graphView.getViewport().setMinY(-100);
        graphView.getViewport().setXAxisBoundsManual(true);
        graphView.getViewport().setYAxisBoundsManual(true);
        graphView.getViewport().setScrollable(true);
        graphView.getViewport().setScalableY(true);

        //graphView.setTitle("My Graph View");
        //// graphView.setTitleTextSize(9);

        graphView.addSeries(series);
        count+=100;
    }

}
