package com.example.rehanr.aatmatrisha;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

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

/**
 * Created by rehan r on 11-11-2015.
 */
public class BackgroundTask extends AsyncTask<String, Void, String> {

//AlertDialog alertDialog;
    boolean flagContinueActivity = true;

    public static final String MyPREFERENCES = "MyPrefs";
    public static final String Name = "nameKey";
    SharedPreferences sharedpreferences;
    ProgressDialog pDialog;


    Context ctx;

    BackgroundTask(Context ctx) {
        this.ctx = ctx;
    }

    String add_info_url, login_url;





    @Override
    protected void onPreExecute() {

        pDialog = new ProgressDialog(ctx);
        pDialog.setTitle("SignUp in progress...");
        pDialog.setMessage("Please Wait...");
        pDialog.setCancelable(false);
        pDialog.show();
        add_info_url = "http://atmatrisha2015.site40.net/register.php";



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







        //login_url="http://atmatrisha2015.site40.net/json_get_data.php";

        //alertDialog = new AlertDialog.Builder(ctx).create();
        //alertDialog.setTitle("Login Details...");

    }


    @Override
    protected String doInBackground(String... params) {
        sharedpreferences = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        //String reg_url="http://10.0.2.2/webapp/register.php";
        // String login_url="http://10.0.2.2/webapp/login.php";
        String method = params[0];

        if (method.equals("register")) {

            String name = params[1];
            String email = params[2];
            String password = params[3];
            String mobile = params[4];
            String college = params[5];

            URL url = null;
            try {
                url = new URL(add_info_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));

                String data = URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                        URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&" +
                        URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8") + "&" +
                        URLEncoder.encode("mobile", "UTF-8") + "=" + URLEncoder.encode(mobile, "UTF-8") + "&" +
                        URLEncoder.encode("college", "UTF-8") + "=" + URLEncoder.encode(college, "UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();

                InputStream IS = httpURLConnection.getInputStream();
                IS.close();

                //for 000webhost.com site
                httpURLConnection.disconnect();
                //for 000webhost.com site

                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(Name, email);
                editor.commit();


                //progress bar

                //progress bar

                return "Registration Successfully Done...";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        /**

         else if(method.equals("login")){

         String emailid=params[1];
         String password=params[2];

         try {
         URL url=new URL(login_url);
         HttpURLConnection httpURLConnection =(HttpURLConnection)url.openConnection();
         InputStream inputStream = httpURLConnection.getInputStream();
         StringBuilder stringBuilder = new StringBuilder();
         BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

         httpURLConnection.setRequestMethod("POST");
         httpURLConnection.setDoOutput(true);
         httpURLConnection.setDoInput(true);

         OutputStream outputStream = httpURLConnection.getOutputStream();
         BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));


         String data = URLEncoder.encode("login_id","UTF-8")+"="+URLEncoder.encode(emailid,"UTF-8")+"&"+
         URLEncoder.encode("login_pass","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");

         bufferedWriter.write(data);
         bufferedWriter.flush();
         bufferedWriter.close();

         while((JSON_STRING = bufferedReader.readLine())!=null ){

         stringBuilder.append(JSON_STRING+"\n");
         }

         bufferedReader.close();
         inputStream.close();
         httpURLConnection.disconnect();

         retur = stringBuilder.toString().trim();

         return "login";
         //  httpURLConnection.setRequestMethod("POST");
         // httpURLConnection.setDoOutput(true);
         // httpURLConnection.setDoInput(true);

         //OutputStream outputStream = httpURLConnection.getOutputStream();
         //BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
         /*
         String data = URLEncoder.encode("login_id","UTF-8")+"="+URLEncoder.encode(emailid,"UTF-8")+"&"+
         URLEncoder.encode("login_pass","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");

         bufferedWriter.write(data);
         bufferedWriter.flush();
         bufferedWriter.close();


         InputStream inputStream = httpURLConnection.getInputStream();
         BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
         String response = "";
         String line="";

         while((line=bufferedReader.readLine())!=null){
         response+= line;
         }

         bufferedReader.close();
         inputStream.close();
         httpURLConnection.disconnect();
         return response;



         } catch (MalformedURLException e) {
         e.printStackTrace();
         } catch (IOException e) {
         e.printStackTrace();
         }
         */

        return null;
    }

    /**private class RegistrationTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected Void doInBackground(Void... params) {
            return null;
        }
    }
*/
    @Override
    protected void onPostExecute(String result) {

        pDialog.dismiss();

        if (flagContinueActivity){
        if (result.equals("Registration Successfully Done...")) {
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
            Intent next = new Intent(ctx, Hive.class);
            ctx.startActivity(next);
        }
        //to disable LoginActivity after backbutton pressed
        ((Activity)ctx).finish();}
        //to disable LoginActivity after backbutton pressed
        /*
        else{
            alertDialog.setMessage(result);
            alertDialog.show();

            if(retur ==null ){
                Toast.makeText(ctx,"Login Failed...",Toast.LENGTH_LONG).show();
            }
            else{
                Intent s = new Intent(ctx,Hive.class);
                ctx.startActivity(s);
            }

        }
        */
    }


}
