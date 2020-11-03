package com.example.islandbuilder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.FrameLayout;

import java.sql.Struct;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FrameLayout mapLayout, selectorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //add fragment to main
        FragmentManager fm = getSupportFragmentManager();
        //add map
        map_Fragment map = (map_Fragment) fm.findFragmentById(R.id.map);
        if(map == null){
            map = new map_Fragment();
            fm.beginTransaction()
                    .add(R.id.map,map)
                    .commit();
        }

        //add selector
        selector_Fragment selector = (selector_Fragment) fm.findFragmentById(R.id.selector);
        if(selector == null){
            selector = new selector_Fragment();
            fm.beginTransaction()
                    .add(R.id.selector,selector)
                    .commit();
        }

    }
}
