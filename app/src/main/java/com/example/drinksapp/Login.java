package com.example.drinksapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    ImageView backHome;
    Button signUp, signIn, forgotPwd;
    EditText email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        backHome = findViewById(R.id.home);

        signUp = findViewById(R.id.signUpLink);
        signIn = findViewById(R.id.signInBtn);
        forgotPwd = findViewById(R.id.forgotPwd);

        email = findViewById(R.id.Email);
        password = findViewById(R.id.Password);

        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, HomePage.class);
                startActivity(intent);
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);
            }
        });

        forgotPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, GetPassword.class);
                startActivity(intent);
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
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
        if (isEmpty(password)) {
            password.setError("enter password!");
            flag = false;
        }
        else {
            if (password.getText().toString().length() < 4) {
                password.setError("password must be at least 4 chars long!");
                flag = false;
            }
        }
        if (flag) {
            //String emailVal = email.getText().toString();
            //String passwordVal = password.getText().toString();
           // if (emailVal.equals("abc@123.com")) {
               // if (passwordVal.equals("jesus")) {
                    Intent intent = new Intent(Login.this, HomePage.class);
                    String a = email.getText().toString();
                    intent.putExtra("email",a);
                    startActivity(intent);
                    this.finish();
               // }
           // } else {
                //Toast t = Toast.makeText(this, "Wrong Email or password!", Toast.LENGTH_SHORT);
              //  t.show();
           // }
        }
    }
}