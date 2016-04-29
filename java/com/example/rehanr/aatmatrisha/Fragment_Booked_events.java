package com.example.rehanr.aatmatrisha;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by rehan r on 16-11-2015.
 */
public class Fragment_Booked_events extends android.app.Fragment {

    public Fragment_Booked_events(){}

    Button bt1,bt2,bt3,bt4,bt5,bt6;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_booked_events, container, false);

        bt1=(Button)rootView.findViewById(R.id.button5);
        bt2=(Button)rootView.findViewById(R.id.button6);
        bt3=(Button)rootView.findViewById(R.id.button7);
        bt4=(Button)rootView.findViewById(R.id.button8);
        bt5=(Button)rootView.findViewById(R.id.button9);
        bt6=(Button)rootView.findViewById(R.id.button10);



        bt1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String event="technical";

                Database_booked_events database_booked_events = new Database_booked_events(rootView.getContext());
                database_booked_events.execute(event);



            }
        });

        bt2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String event="cultural";

                Database_booked_events database_booked_events = new Database_booked_events(rootView.getContext());
                database_booked_events.execute(event);

            }
        });

        bt3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String event="photography";

                Database_booked_events database_booked_events = new Database_booked_events(rootView.getContext());
                database_booked_events.execute(event);

            }
        });

        bt4.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String event="fine_art";

                Database_booked_events database_booked_events = new Database_booked_events(rootView.getContext());
                database_booked_events.execute(event);

            }
        });

        bt5.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String event="informals";

                Database_booked_events database_booked_events = new Database_booked_events(rootView.getContext());
                database_booked_events.execute(event);

            }
        });

        bt6.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String event="literary";

                Database_booked_events database_booked_events = new Database_booked_events(rootView.getContext());
                database_booked_events.execute(event);

            }
        });


        return rootView;
    }





}

