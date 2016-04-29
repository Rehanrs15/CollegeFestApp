package com.example.rehanr.aatmatrisha;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rehan r on 16-11-2015.
 */
public class Database_booked_events extends AsyncTask<String,Void,String> {


    ProgressDialog pDialog;
    String login_url;
    boolean flagContinueActivity = true;
    public static ArrayList<String> items;

    public static final String MyPREFERENCES = "MyPrefs";




    Context ctx;
    Database_booked_events(Context ctx){
        this.ctx=ctx;
    }

    @Override
    protected void onPreExecute() {


        pDialog = new ProgressDialog(ctx);
        pDialog.setTitle("Loading...");
        pDialog.setMessage("Please Wait...");
        pDialog.setCancelable(false);
        pDialog.show();
        login_url="http://aatmatrisha2015.net/view_item.php";

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


        String method = params[0];

        if(method.equals("technical")) {
            URL url = null;
            try {
                url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));

                String data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(value, "UTF-8")+"&"+
                        URLEncoder.encode("event", "UTF-8") + "=" + URLEncoder.encode(method, "UTF-8");


                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();

                InputStream IS = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(IS, "iso-8859-1"));
                String response = "";
                String line = "";

                while ((line = bufferedReader.readLine()) != null) {
                    response += line;
                }
                bufferedReader.close();
                IS.close();
                httpURLConnection.disconnect();

                //SharedPreferences.Editor editor = sharedpreferences.edit();

                //editor.putString(Name, email);
                //editor.commit();

                return response;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(method.equals("cultural")) {
            URL url = null;
            try {
                url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));

                String data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(value, "UTF-8")+"&"+
                        URLEncoder.encode("event", "UTF-8") + "=" + URLEncoder.encode(method, "UTF-8");


                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();

                InputStream IS = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(IS, "iso-8859-1"));
                String response = "";
                String line = "";

                while ((line = bufferedReader.readLine()) != null) {
                    response += line;
                }
                bufferedReader.close();
                IS.close();
                httpURLConnection.disconnect();

                //SharedPreferences.Editor editor = sharedpreferences.edit();

                //editor.putString(Name, email);
                //editor.commit();

                return response;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        else if(method.equals("photography")) {
            URL url = null;
            try {
                url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));

                String data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(value, "UTF-8")+"&"+
                        URLEncoder.encode("event", "UTF-8") + "=" + URLEncoder.encode(method, "UTF-8");


                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();

                InputStream IS = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(IS, "iso-8859-1"));
                String response = "";
                String line = "";

                while ((line = bufferedReader.readLine()) != null) {
                    response += line;
                }
                bufferedReader.close();
                IS.close();
                httpURLConnection.disconnect();

                //SharedPreferences.Editor editor = sharedpreferences.edit();

                //editor.putString(Name, email);
                //editor.commit();

                return response;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        else if(method.equals("fine_art")) {
            URL url = null;
            try {
                url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));

                String data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(value, "UTF-8")+"&"+
                        URLEncoder.encode("event", "UTF-8") + "=" + URLEncoder.encode(method, "UTF-8");


                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();

                InputStream IS = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(IS, "iso-8859-1"));
                String response = "";
                String line = "";

                while ((line = bufferedReader.readLine()) != null) {
                    response += line;
                }
                bufferedReader.close();
                IS.close();
                httpURLConnection.disconnect();

                //SharedPreferences.Editor editor = sharedpreferences.edit();

                //editor.putString(Name, email);
                //editor.commit();

                return response;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        else if(method.equals("informals")) {
            URL url = null;
            try {
                url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));

                String data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(value, "UTF-8")+"&"+
                        URLEncoder.encode("event", "UTF-8") + "=" + URLEncoder.encode(method, "UTF-8");


                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();

                InputStream IS = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(IS, "iso-8859-1"));
                String response = "";
                String line = "";

                while ((line = bufferedReader.readLine()) != null) {
                    response += line;
                }
                bufferedReader.close();
                IS.close();
                httpURLConnection.disconnect();

                //SharedPreferences.Editor editor = sharedpreferences.edit();

                //editor.putString(Name, email);
                //editor.commit();

                return response;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        else if(method.equals("literary")) {
            URL url = null;
            try {
                url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));

                String data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(value, "UTF-8")+"&"+
                        URLEncoder.encode("event", "UTF-8") + "=" + URLEncoder.encode(method, "UTF-8");


                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();

                InputStream IS = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(IS, "iso-8859-1"));
                String response = "";
                String line = "";

                while ((line = bufferedReader.readLine()) != null) {
                    response += line;
                }
                bufferedReader.close();
                IS.close();
                httpURLConnection.disconnect();

                //SharedPreferences.Editor editor = sharedpreferences.edit();

                //editor.putString(Name, email);
                //editor.commit();

                return response;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        return null;
    }



    String res;
    @Override
    protected void onPostExecute(String result) {
        pDialog.dismiss();
        Pattern pattern=Pattern.compile(Pattern.quote("\"") + "(.*)" + Pattern.quote("\"<"));
        Matcher matcher = pattern.matcher(result);
        if(matcher.find()) {
            result = matcher.group();
        }
        String r=result;
        r=r.replaceAll("<", "");
        r=r.replaceAll("\""," ").trim();
        items = new  ArrayList<String>(Arrays.asList(r.split("  ")));

        Intent i =new Intent(ctx,view_booked_events.class);
        ctx.startActivity(i);

    }

    public ArrayList<String> getArray(){
        return items;
    }


}
