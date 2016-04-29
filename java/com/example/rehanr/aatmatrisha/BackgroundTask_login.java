package com.example.rehanr.aatmatrisha;

import android.app.Activity;
import android.app.AlertDialog;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rehan r on 14-11-2015.
 */
public class BackgroundTask_login extends AsyncTask<String,Void,String> {


    Context ctx;
    ProgressDialog pDialog;
    String login_url;
    boolean flagContinueActivity = true;

    public static final String MyPREFERENCES = "MyPrefs";
    public static final String Name = "nameKey";
    SharedPreferences sharedpreferences;
    BackgroundTask_login(Context ctx){
        this.ctx=ctx;
    }

    @Override
    protected void onPreExecute() {
        pDialog = new ProgressDialog(ctx);
        pDialog.setTitle("Login in progress...");
        pDialog.setMessage("Please Wait...");
        pDialog.setCancelable(false);
        pDialog.show();
        login_url="http://atmatrisha2015.site40.net/login_new.php";

        new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                //mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                //mTextField.setText("done!");
                pDialog.dismiss();
                flagContinueActivity = false;
                Toast.makeText(ctx,"Please check your internet  connection...",Toast.LENGTH_LONG).show();
                ((Activity)ctx).finish();
            }

        }.start();



    }

    @Override
    protected String doInBackground(String... params) {
        sharedpreferences = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);


        String method = params[0];

        if (method.equals("login")) {

            String email = params[1];
            String pass = params[2];

            URL url = null;
            try {
                url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));

                String data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&" +
                        URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();

                InputStream IS = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(IS,"iso-8859-1"));
                String response = "";
                String line="";

                while((line=bufferedReader.readLine())!=null){
                    response+= line;
                }
                bufferedReader.close();
                IS.close();
                httpURLConnection.disconnect();
                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(Name, email);
                editor.commit();

                return response;



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        return null;
    }

    @Override
    protected void onPostExecute(String result) {

        pDialog.dismiss();
        Pattern pattern=Pattern.compile(Pattern.quote("\"") + "(.*?)" + Pattern.quote("\""));
        Matcher matcher = pattern.matcher(result);
        if(matcher.find()) {
            result = matcher.group();
        }

        if(flagContinueActivity) {
            if (result.equals("\"Sucessfull login\"")) {
                Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
                Intent i = new Intent(ctx, Hive.class);
                ctx.startActivity(i);
                ((Activity) ctx).finish();
            } else if (result.equals("\"login failed\"")) {
                Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
                ((Activity) ctx).finish();
            }
        }


    }
}
