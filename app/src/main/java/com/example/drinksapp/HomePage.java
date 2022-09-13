package com.example.drinksapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
public class HomePage extends AppCompatActivity {
    private static int switcherPressedCount = 2;
    private static int switcherPressedCount2 = 2;
    ScrollView myScrollView;
    LinearLayout btnLayout;
    TextView txtView;

    ImageView search, regOrSign;
    Button signIn, signUp, cocoaExp, shakesExp, softDrinksExp, cocktailsExp, specialsExp, arrowTop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        myScrollView = findViewById(R.id.myScrollView);
        btnLayout = findViewById(R.id.btnLayout);
        txtView = findViewById(R.id.txtView);

        regOrSign = findViewById(R.id.signUpOrReg);
        search = findViewById(R.id.search);

        signIn = findViewById(R.id.signIn);
        signUp = findViewById(R.id.signUp);

        cocoaExp = findViewById(R.id.chocoExp);
        shakesExp = findViewById(R.id.milkyExp);
        softDrinksExp = findViewById(R.id.softExp);
        cocktailsExp = findViewById(R.id.cocktailExp);
        specialsExp = findViewById(R.id.specialsExp);
        arrowTop = findViewById(R.id.arrow);

        String stringA;
        if (savedInstanceState == null) {
            Bundle bundle = getIntent().getExtras();
            if (bundle == null) {
                stringA = null;
            } else {
                stringA = bundle.getString("email");
                txtView.setText(stringA);
                if (txtView.getText().toString() != "Home") {
                    regOrSign.setVisibility(View.GONE);
                }
            }
        } else {
            stringA = (String) savedInstanceState.getSerializable("email");
            txtView.setText(stringA);
            if (txtView.getText().toString() != "Home") {
                regOrSign.setVisibility(View.GONE);
            }
        }

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, AllDrinks.class);
                startActivity(intent);
            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void clickEventUser(View view) { //'clickEvent'onClick method added to 'id : signUpOrReg' ImageView in activity_home_page.xml
        btnLayout.setVisibility(btnLayout.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
        signIn.setVisibility(signIn.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
        signUp.setVisibility(signUp.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
        if (switcherPressedCount%2 == 0) {
            regOrSign.setBackgroundResource(R.drawable.delete);
            switcherPressedCount = 3; //to avoid reaching maximum int limit
        }
        else {
            regOrSign.setBackgroundResource(R.drawable.user);
            switcherPressedCount = 2; //to avoid reaching maximum int limit
        }

        //CONTROL WHAT THE BUTTONS DO WHEN VISIBLE
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //regOrSign.setVisibility(regOrSign.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
                Intent intent = new Intent(HomePage.this, Login.class);
                startActivity(intent);
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, SignUp.class);
                startActivity(intent);
            }
        });
    }

    /*public void clickEventSearch(View view) {
        searchDrinks.setVisibility(searchDrinks.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
        if (switcherPressedCount2%2 == 0) {
            search.setBackgroundResource(R.drawable.delete);
            switcherPressedCount2 = 3; //to avoid reaching maximum int limit
        }
        else {
            search.setBackgroundResource(R.drawable.search);
            switcherPressedCount2 = 2; //to avoid reaching maximum int limit
        }
    }*/


    public void clickEventChoco(View view) {
        cocoaExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, Cocoa.class);
                startActivity(intent);
            }
        });
    }

    public void clickEventMilky(View view) {
        shakesExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, Shakes.class);
                startActivity(intent);
            }
        });
    }

    public void clickEventCoffee(View view) {
        softDrinksExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, SoftDrinks.class);
                startActivity(intent);
            }
        });
    }

    public void clickEventSoda(View view) {
        cocktailsExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, Cocktails.class);
                startActivity(intent);
            }
        });
    }

    public void clickEventSpecials(View view) {
        specialsExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, Specials.class);
                startActivity(intent);
            }
        });
    }

    public void clickEventArrow(View view) {
        arrowTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               myScrollView.smoothScrollTo(0,0);
            }
        });
    }


}