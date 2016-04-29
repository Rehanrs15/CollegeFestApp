package com.example.rehanr.aatmatrisha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login_main extends AppCompatActivity {


    EditText input_mail,input_pass;
    String mail,pass;
    Button btn1;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);

        TextView link=(TextView)findViewById(R.id.link_signup);

        input_mail=(EditText)findViewById(R.id.input_email);
        input_pass=(EditText)findViewById(R.id.input_password);
        btn1=(Button)findViewById(R.id.btn_login);


        btn1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                mail=input_mail.getText().toString();
                pass=input_pass.getText().toString();


                if(mail.equals("") || pass.equals("")){

                    if(mail.equals("") || !validEmail(input_mail.getText().toString())){
                        Toast.makeText(Login_main.this,"enter a valid email id",Toast.LENGTH_LONG).show();
                    }
                    else if(pass.equals("") || pass.length()<7){
                        Toast.makeText(Login_main.this,"enter a valid password",Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    String method = "login";
                    BackgroundTask_login backgroundTask = new BackgroundTask_login(Login_main.this);
                    backgroundTask.execute(method, mail, pass);

                }
            }
        });



        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent signup = new Intent(Login_main.this,LoginActivity.class);
                startActivity(signup);
            }
        });


    }


    private boolean validEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
