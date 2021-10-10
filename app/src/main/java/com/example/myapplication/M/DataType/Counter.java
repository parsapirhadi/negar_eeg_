package com.example.myapplication.M.DataType;

public class Counter {


int b=0;
int b1=0;

 int all_count=0;

    public int getAll_count() {
        return all_count;
    }

    public void setAll_count(int all_count) {
        this.all_count = all_count;
    }

    public float [] all=new float[999999];


    public float [][] channel=new float[64][9000];
    int channel_count=0;


    public float getAll(int i) {
        return all[i];
    }

    public void setAll(float f,int i) {
        this.all[i]=f;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
    public int getB1() {
        return b1;
    }

    public void setB1(int b) {
        this.b1 = b1;
    }

    public float getChannel(int i,int j) {
        return channel[i][j];
    }

    public void setChannel(float f,int i,int j) {
        this.channel[i][j]=f;
    }


    public int getChannel_count() {
        return channel_count;
    }

    public void setChannel_count(int channel_count) {
        this.channel_count = channel_count;
    }
}
