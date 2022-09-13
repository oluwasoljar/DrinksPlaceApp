package com.example.drinksapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class GetPassword extends AppCompatActivity {
    ImageView backHome;
    Button signUp, retrievePwd, homeLink;
    EditText email;
    LinearLayout messageLay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_password);

        backHome = findViewById(R.id.home);
        signUp = findViewById(R.id.signUpLink);
        retrievePwd = findViewById(R.id.retrieveBtn);
        messageLay = findViewById(R.id.messageLayout);
        homeLink = findViewById(R.id.homeLink);
        email = findViewById(R.id.Email);

        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GetPassword.this, HomePage.class);
                startActivity(intent);
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GetPassword.this, SignUp.class);
                startActivity(intent);
            }
        });

        homeLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GetPassword.this, HomePage.class);
                startActivity(intent);
            }
        });

        retrievePwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkDataEntered();


            }
        });
    }

    private boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    private boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    private void checkDataEntered() {
        boolean flag = true;
        if (isEmpty(email)) {
            email.setError("enter email!");
            flag = false;
        }
        else {
            if (isEmail(email) == false) {
                email.setError("invalid email!");
                flag = false;
            }
        }

        if (flag) {
            messageLay.setVisibility(messageLay.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
        }
    }

}