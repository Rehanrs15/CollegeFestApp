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

public class HomeFragment extends Fragment {

    public HomeFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);


        TextView txt1 = (TextView)rootView.findViewById(R.id.textView11);
        TextView txt2 = (TextView)rootView.findViewById(R.id.textView13);
        TextView txt3 = (TextView)rootView.findViewById(R.id.textView15);
        TextView txt4 = (TextView)rootView.findViewById(R.id.textView17);


        txt1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent young = new Intent(getActivity(),young_manager.class);
                startActivity(young);
            }
        });

        txt2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent inge = new Intent(getActivity(),ingeneer.class);
                startActivity(inge);
            }
        });


        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent young = new Intent(getActivity(),junkyard.class);
                startActivity(young);
            }
        });

        txt4.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent young = new Intent(getActivity(),bizat14.class);
                startActivity(young);
            }
        });











        return rootView;
    }
}