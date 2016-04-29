package com.example.rehanr.aatmatrisha;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by rehan r on 13-11-2015.
 */
public class HomeFragment4 extends Fragment {

    public HomeFragment4(){}

    TextView txt1;
    TextView txt2;
    TextView txt3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home4, container, false);

        txt1=(TextView)rootView.findViewById(R.id.textView11);
        txt2=(TextView)rootView.findViewById(R.id.textView13);
        txt3=(TextView)rootView.findViewById(R.id.textView15);

        txt1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent next = new Intent(getActivity(),art_race.class);
                startActivity(next);
            }
        });

        txt2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent next = new Intent(getActivity(),body_painting.class);
                startActivity(next);
            }
        });


        txt3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent next = new Intent(getActivity(),sketch_at.class);
                startActivity(next);
            }
        });

        return rootView;
    }
}
