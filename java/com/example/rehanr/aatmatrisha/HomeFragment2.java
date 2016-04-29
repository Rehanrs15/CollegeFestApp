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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeFragment2 extends Fragment {

    public HomeFragment2(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_home2, container, false);
        TextView txt1= (TextView)rootView.findViewById(R.id.textView11);
        TextView txt2= (TextView)rootView.findViewById(R.id.textView13);
        TextView txt3= (TextView)rootView.findViewById(R.id.textView15);

        txt1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i =new Intent(getActivity(),photo_talk_ramesh.class);
                startActivity(i);
            }
        });
        txt2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i =new Intent(getActivity(),pixil_this.class);
                startActivity(i);
            }
        });

        txt3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i =new Intent(getActivity(),layers.class);
                startActivity(i);
            }
        });

        return rootView;
    }




}