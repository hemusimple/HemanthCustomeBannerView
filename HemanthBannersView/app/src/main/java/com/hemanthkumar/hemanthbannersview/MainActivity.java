package com.hemanthkumar.hemanthbannersview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.hemanthkumar.hemanthcustomebannerview.customebanners.CustomeBanner customeBanner = new com.hemanthkumar.hemanthcustomebannerview.customebanners.CustomeBanner(this);
        ArrayList<String> imagepaths = new ArrayList<>();
        imagepaths.add("https://dev.danden.com/uploads/songs/jun2018/1528921273.jpg");
        imagepaths.add("https://dev.danden.com/uploads/songs/jun2018/1528920939.jpg");
        imagepaths.add("https://dev.danden.com/uploads/songs/jun2018/1528921273.jpg");
        imagepaths.add("https://dev.danden.com/uploads/songs/jun2018/1528920939.jpg");
        customeBanner.setAllImages(imagepaths);
        setContentView(customeBanner);
    }
}
