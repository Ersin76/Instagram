package com.ozturkersin.instagramcloneparse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity {

    EditText usernameText, passwordText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameText = findViewById(R.id.sign_up_acitivty_name_text);
        passwordText = findViewById(R.id.sign_up_activity_password_text);

        ParseUser parseUser=ParseUser.getCurrentUser();

        if (parseUser!=null){
            Intent intent=new Intent(getApplicationContext(),FeedActivity.class);// bu satırı yazınca "view" kırmızı oldu.
            startActivity(intent);// bu satırı yazınca "view" kırmızı oldu.

    }


    public void giris(View view) {
        ParseUser.logInInBackground(usernameText.getText().toString(), passwordText.getText().toString(), new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e!=null){
                    Toast.makeText(getApplicationContext(),e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Hoşgeldiniz!!!" +user.getUsername(),Toast.LENGTH_LONG).show();
                     //intent
                    Intent intent=new Intent(getApplicationContext(),FeedActivity.class);
                    startActivity(intent);
                }

            }
        });

    }

    public void kaydol(View view) {

        ParseUser user= new ParseUser();
        user.setUsername(usernameText.getText().toString());
        user.setPassword(passwordText.getText().toString());

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e!=null){
                    Toast.makeText(getApplicationContext(),e.getLocalizedMessage(),Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(getApplicationContext(),"User Created!!!",Toast.LENGTH_LONG).show();
                    //intent
                    Intent intent=new Intent(getApplicationContext(),FeedActivity.class);
                    startActivity(intent);

                }


            }
        });


    }

}




