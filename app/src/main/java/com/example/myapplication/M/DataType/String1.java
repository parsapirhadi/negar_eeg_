package com.example.myapplication.M.DataType;

import java.io.Serializable;

public class String1 implements Serializable {
    String montage="";
String filepatch="/storage/emulated/0/Download/g8.txt";
    int line_count=0;

    public int getLine_count() {
        return line_count;
    }

    public void setLine_count(int line_count) {
        this.line_count = line_count;
    }
    public String getFilepatch() {
        return filepatch;
    }

    public void setFilepatch(String filepatch) {
        this.filepatch = filepatch;
    }

    public String[] getPivote() {
        return pivote;
    }

    public void setPivote(String[] pivote) {
        this.pivote = pivote;
    }

    public String[] pivote =new String[64];


    public String getMontage() {
        return montage;
    }

    public void setMontage(String montage) {
        this.montage = montage;
    }
}
