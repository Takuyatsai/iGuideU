package com.example.watertank;

import com.google.gson.annotations.SerializedName;

public class Growth {

    @SerializedName("sr_no")
    private int no;
    @SerializedName("rec_temp")
    private Float temp;

    public int get_no() {
        return no;
    }

    public Float get_temp() {
        return temp;
    }
}
