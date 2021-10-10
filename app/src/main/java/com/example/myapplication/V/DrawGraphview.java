package com.example.myapplication.V;

import android.graphics.Color;

import com.example.myapplication.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class DrawGraphview {
   GraphView graphView;

    public DrawGraphview(GraphView graphView) {
        this.graphView = graphView;
    }

public void draw(){
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

    graphView.setTitle("My Graph View");
    //// graphView.setTitleTextSize(9);

    graphView.addSeries(series);

    series.setColor(Color.rgb(30,30,30));

    series.setDrawBackground(false);
}

}
