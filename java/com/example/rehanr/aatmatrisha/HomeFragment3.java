package com.example.rehanr.aatmatrisha;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class HomeFragment3 extends Fragment {

    public HomeFragment3(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home_3, container, false);

        TextView txt1 = (TextView)rootView.findViewById(R.id.textView11);
        TextView txt2 = (TextView)rootView.findViewById(R.id.textView13);
        TextView txt3 = (TextView)rootView.findViewById(R.id.textView15);
        TextView txt4 = (TextView)rootView.findViewById(R.id.textView17);
        txt1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent biz = new Intent(getActivity(), tag_the_story.class);
                startActivity(biz);
            }
        });

        txt2.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent biz = new Intent(getActivity(), jam.class);
                startActivity(biz);
            }
        });

        txt3.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent biz = new Intent(getActivity(), arnab_news.class);
                startActivity(biz);
            }
        });

        txt4.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent biz = new Intent(getActivity(), wordpouri.class);
                startActivity(biz);
            }
        });

        return rootView;
    }





}
