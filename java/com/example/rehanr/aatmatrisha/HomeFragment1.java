package com.example.rehanr.aatmatrisha;

/**
 * Created by rehan r on 25-10-2015.
 */
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomeFragment1 extends Fragment {

    public HomeFragment1(){}
    TextView txt1,txt2,txt3,txt4;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home1, container, false);

        txt1=(TextView)rootView.findViewById(R.id.textView11);
        txt2=(TextView)rootView.findViewById(R.id.textView13);
        txt3=(TextView)rootView.findViewById(R.id.textView15);
        txt4=(TextView)rootView.findViewById(R.id.textView17);


        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i= new Intent(getActivity(),nritya_virasat.class);
                startActivity(i);
            }
        });


        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getActivity(),street.class);
                startActivity(i);
            }
        });


        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getActivity(),junoon.class);
                startActivity(i);
            }
        });

        txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getActivity(),at_got_talent.class);
                startActivity(i);
            }
        });

        return rootView;
    }
}
