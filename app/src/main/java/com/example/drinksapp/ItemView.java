package com.example.drinksapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ItemView extends AppCompatActivity {

    ImageView imageView, backHome;
    TextView textViewName, textViewDesc;

    AllDrinksModel allDrinksModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_view);

        imageView = findViewById(R.id.imageViewItem);
        backHome = findViewById(R.id.home);
        textViewName = findViewById(R.id.textViewName);
        textViewDesc = findViewById(R.id.textViewDesc);

        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ItemView.this, HomePage.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();

        if (intent.getExtras() != null) {
            allDrinksModel = (AllDrinksModel) intent.getSerializableExtra("item");

            imageView.setImageResource(allDrinksModel.getImage());
            textViewName.setText(allDrinksModel.getName());
            textViewDesc.setText(allDrinksModel.getDesc());
        }
    }
}