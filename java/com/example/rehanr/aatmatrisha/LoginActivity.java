package com.example.rehanr.aatmatrisha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LoginActivity extends AppCompatActivity {



    EditText text1 ;
    EditText text2;
    EditText text3 ;
    EditText text4;
    EditText text5 ;
    Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


            text1 = (EditText)findViewById(R.id.editText2);
            text2 = (EditText)findViewById(R.id.editText);
            text3 = (EditText)findViewById(R.id.editText3);
            text4 = (EditText)findViewById(R.id.editText4);
            text5 = (EditText)findViewById(R.id.editText5);
            but = (Button)findViewById(R.id.button);

        but.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //@rehan get the value from the edittext
                String t1 = text1.getText().toString();
                String t2 = text2.getText().toString();
                String t3 = text3.getText().toString();
                String t4 = text4.getText().toString();
                String t5 = text5.getText().toString();


                if (t1.equals("") || t2.equals("") ||t3.equals("")|| t4.equals("")|| t5.equals("")||!isValidEmail(text2.getText().toString()) )
                {
                    if(t1.equals("")){
                        Toast.makeText(LoginActivity.this,"enter a valid user name",Toast.LENGTH_LONG).show();
                    }
                    else if(t2.equals("") || !isValidEmail(text2.getText().toString())){
                        Toast.makeText(LoginActivity.this,"enter a valid email id",Toast.LENGTH_LONG).show();
                    }
                    else if(t3.equals("") || t3.length()<7){
                        Toast.makeText(LoginActivity.this,"password length must be greater the 7",Toast.LENGTH_LONG).show();
                    }
                    else if(t4.equals("") || !isValidnumber(t4)){
                        Toast.makeText(LoginActivity.this,"enter a valid phone number",Toast.LENGTH_LONG).show();
                    }
                    else if(t5.equals("")){
                        Toast.makeText(LoginActivity.this,"enter a valid college name",Toast.LENGTH_LONG).show();
                    }

                /*
                    Toast.makeText(LoginActivity.this,"this field cannot be left blank",Toast.LENGTH_LONG).show();
                    text1.setText("");
                    text2.setText("");
                    text3.setText("");
                    text4.setText("");
                    text5.setText("");
                    */
                }
                else {
                    String method = "register";
                    BackgroundTask backgroundTask = new BackgroundTask(LoginActivity.this);
                    backgroundTask.execute(method, t1, t2, t3, t4, t5);
                }

            }


        } );
    }

    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isValidnumber(String number) {
        String NUMBER_PATTERN = "[7-9][0-9]{9}$";

        Pattern pattern = Pattern.compile(NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
