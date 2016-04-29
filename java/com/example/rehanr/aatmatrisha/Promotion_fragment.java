package com.example.rehanr.aatmatrisha;

/**
 * Created by rehan r on 25-10-2015.
 */
import android.app.ActionBar;
import android.app.Fragment;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class Promotion_fragment extends Fragment {

    public Promotion_fragment(){}



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.promotion_fragment, container, false);
//        getActivity().getActionBar().hide();

        Button b1 = (Button)rootView.findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ComponentName name = new ComponentName("com.whatsapp", "com.whatsapp.ContactPicker");
                Intent oShareIntent = new Intent();
                oShareIntent.setComponent(name);
                String message = "Hey!! Check out Aatmatrisha App for your smartphone.Download it today from " +
                        "http://aatmatrisha2016.com/dl/";
                oShareIntent.setType("text/plain");
                oShareIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
                startActivity(oShareIntent);

            }
        });


                    TextView txt1 = (TextView) rootView.findViewById(R.id.t1);
                    TextView txt2 = (TextView) rootView.findViewById(R.id.t2);
                    txt1.startAnimation(AnimationUtils.loadAnimation(inflater.getContext(), android.R.anim.fade_in));

                    txt2.startAnimation(AnimationUtils.loadAnimation(inflater.getContext(), android.R.anim.fade_in));

        return rootView;

    }
/*
    public void promote(View view){
        final ComponentName name = new ComponentName("com.whatsapp", "com.whatsapp.ContactPicker");
        Intent oShareIntent = new Intent();
        oShareIntent.setComponent(name);
        String message="Hey!! Check out Aatmatrisha App for your smartphone.Download it today from " +
                "http://aatmatrisha2016.com/dl/";
        oShareIntent.setType("text/plain");
        oShareIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
        startActivity(oShareIntent);
    }
    */
}
