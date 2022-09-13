package com.example.drinksapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {
    ImageView backHome;
    EditText email, pass, repass, phone, surname, firstname, lastname;
    RadioGroup getGender;
    RadioButton male, female;
    Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        backHome = findViewById(R.id.home);



        email = findViewById(R.id.Email);
        pass = findViewById(R.id.Password);
        repass = findViewById(R.id.conPassword);
        phone = findViewById(R.id.Phone);
        surname = findViewById(R.id.surName);
        firstname = findViewById(R.id.firstName);
        lastname = findViewById(R.id.otherName);
        getGender = findViewById(R.id.group);
        male = findViewById(R.id.radioMale);
        female = findViewById(R.id.radioFemale);
        signUp = findViewById(R.id.signUpBtn);

        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, HomePage.class);
                startActivity(intent);
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
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
            email.setError("enter email");
            flag = false;
        }
        else {
            if (isEmail(email) == false) {
                email.setError("invalid email!");
            }
        }

        if (isEmpty(pass)) {
            pass.setError("enter password");
            flag = false;
        }
        else {
            if (pass.getText().toString().length() < 4) {
                pass.setError("password must be at least 4 chars long!");
                flag = false;
            }
        }

        if (isEmpty(repass)) {
            repass.setError("confirm password");
            flag = false;
        }
        else {
            if (!pass.getText().toString().equals(repass.getText().toString())) {
                repass.setError("password does not match");
                flag = false;
            }
        }

        if (isEmpty(phone)) {
            phone.setError("enter phone number");
            flag = false;
        }

        if (isEmpty(surname)) {
            surname.setError("enter surname");
            flag = false;
        }

        if (isEmpty(firstname)) {
            firstname.setError("enter first name");
            flag = false;
        }

        if (isEmpty(lastname)) {
            lastname.setError("enter last name");
            flag = false;
        }

        final int id = getGender.getCheckedRadioButtonId();
        if (getGender.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), "select gender", Toast.LENGTH_SHORT).show();
        }

        if (flag) {
            Intent intent = new Intent(SignUp.this, Login.class);
            String a = email.getText().toString();
            intent.putExtra("email",a);

            String b = phone.getText().toString();
            intent.putExtra("phone",b);

            String c = surname.getText().toString();
            intent.putExtra("surname",c);

            String d = firstname.getText().toString();
            intent.putExtra("email",d);

            String e = lastname.getText().toString();
            intent.putExtra("lastname",e);

            String f = email.getText().toString();
            intent.putExtra("email",f);

            String str = null;
            if (male.isChecked()) {
                str = ((RadioButton)findViewById(id)).getText().toString();
            } else if (female.isChecked()) {
                str = ((RadioButton)findViewById(id)).getText().toString();
            }
            intent.putExtra("genderChecked", str);
            startActivity(intent);
            this.finish();
        }
    }
}