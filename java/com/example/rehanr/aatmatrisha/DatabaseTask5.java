package com.example.rehanr.aatmatrisha;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Random;

/**
 * Created by rehan r on 13-11-2015.
 */
public class DatabaseTask5 extends AsyncTask<String,Void,String > {


    AlertDialog aDialog;
    String ev,code;

    boolean flagContinueActivity = true;
    Context ctx;

    DatabaseTask5(Context ctx) {
        this.ctx = ctx;
    }

    String tech_url;
    ProgressDialog pDialog;
    public static final String MyPREFERENCES = "MyPrefs" ;


    @Override
    protected void onPreExecute() {

        pDialog = new ProgressDialog(ctx);
        pDialog.setTitle("Booking in progress...");
        pDialog.setMessage("Please Wait...");
        pDialog.setCancelable(false);
        pDialog.show();

        tech_url="http://atmatrisha2015.site40.net/informals.php";


        new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                //mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                //mTextField.setText("done!");
                pDialog.dismiss();
                flagContinueActivity = false;
                Toast.makeText(ctx, "Please check your internet  connection...", Toast.LENGTH_LONG).show();
                ((Activity)ctx).finish();
            }

        }.start();



    }



    @Override
    protected String doInBackground(String... params) {

        SharedPreferences sharedpreferences = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String value = sharedpreferences.getString("nameKey", "");

        /*
        code to clear the session value

        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.clear();
        editor.commit();
        */

        String method=params[0];

        if(method.equals("hoga")){

             ev="#HOG";
            Random ran =new Random();
            int s=ran.nextInt(5000000);
            String n=new String(String.valueOf(s));
           // String code;
            code=ev.concat(n);

            String event_name="HOGATHON";

            URL url = null;
            try {
                url = new URL(tech_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));

                String data = URLEncoder.encode("email", "UTF-8") +"="+URLEncoder.encode(value,"UTF-8")+"&"+
                        URLEncoder.encode("event","UTF-8") +"="+URLEncoder.encode(event_name,"UTF-8")+"&"+
                        URLEncoder.encode("code","UTF-8") +"="+URLEncoder.encode(code,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();

                InputStream IS=httpURLConnection.getInputStream();
                IS.close();

                //for 000webhost.com site
                httpURLConnection.disconnect();
                //for 000webhost.com site

                return "Successfully Booked...";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(method.equals("min")){

           ev="#MIN";
            Random ran =new Random();
            int s=ran.nextInt(5000000);
            String n=new String(String.valueOf(s));
           // String code;
            code=ev.concat(n);

            String event_name="MINUTE TO WIN";

            URL url = null;
            try {
                url = new URL(tech_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));

                String data = URLEncoder.encode("email", "UTF-8") +"="+URLEncoder.encode(value,"UTF-8")+"&"+
                        URLEncoder.encode("event","UTF-8") +"="+URLEncoder.encode(event_name,"UTF-8")+"&"+
                        URLEncoder.encode("code","UTF-8") +"="+URLEncoder.encode(code,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();

                InputStream IS=httpURLConnection.getInputStream();
                IS.close();

                //for 000webhost.com site
                httpURLConnection.disconnect();
                //for 000webhost.com site

                return "Successfully Booked...";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }



        }

        else if(method.equals("wiz")){

            ev="#WIZ";
            Random ran =new Random();
            int s=ran.nextInt(5000000);
            String n=new String(String.valueOf(s));
            //String code;
            code=ev.concat(n);

            String event_name="WIZARD CHESS";

            URL url = null;
            try {
                url = new URL(tech_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));

                String data = URLEncoder.encode("email", "UTF-8") +"="+URLEncoder.encode(value,"UTF-8")+"&"+
                        URLEncoder.encode("event","UTF-8") +"="+URLEncoder.encode(event_name,"UTF-8")+"&"+
                        URLEncoder.encode("code","UTF-8") +"="+URLEncoder.encode(code,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();

                InputStream IS=httpURLConnection.getInputStream();
                IS.close();

                //for 000webhost.com site
                httpURLConnection.disconnect();
                //for 000webhost.com site

                return "Successfully Booked...";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }



        }
        else if(method.equals("slam")){

            ev="#SLM";
            Random ran =new Random();
            int s=ran.nextInt(5000000);
            String n=new String(String.valueOf(s));
            //String code;
            code=ev.concat(n);

            String event_name="SLAMBALL";

            URL url = null;
            try {
                url = new URL(tech_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));

                String data = URLEncoder.encode("email", "UTF-8") +"="+URLEncoder.encode(value,"UTF-8")+"&"+
                        URLEncoder.encode("event","UTF-8") +"="+URLEncoder.encode(event_name,"UTF-8")+"&"+
                        URLEncoder.encode("code","UTF-8") +"="+URLEncoder.encode(code,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();

                InputStream IS=httpURLConnection.getInputStream();
                IS.close();

                //for 000webhost.com site
                httpURLConnection.disconnect();
                //for 000webhost.com site

                return "Successfully Booked...";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }



        }



        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        pDialog.dismiss();

        //display a alert dialog
        aDialog = new AlertDialog.Builder(ctx).create();
        aDialog.setTitle("Your Referral Code");

        aDialog.setMessage(code);
        aDialog.show();
        //display a dialog
        
        if (flagContinueActivity) {
            Toast.makeText(ctx, s, Toast.LENGTH_LONG).show();
        }
    }
}

