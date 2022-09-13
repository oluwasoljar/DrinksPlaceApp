package com.example.drinksapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Cocoa extends AppCompatActivity {

    ImageView backHome;
    ListView listView;
    String cocoaDrinks[] = {"LATTE", "CAPUCCINO", "FILTER", "BLACK COFFEE"};

    String recipes[] = {"Expresso, Milk, Hot Water",
                        "Double Expresso, Steamed Milk Foam, Hot Milk, Water",
                        "Coffee, Hot Milk, Sugar, Froth, Water",
                        "Coffee, Sugar, Hot Water"};

    int drinksImg[] = {R.drawable.latte, R.drawable.cappuccino, R.drawable.filter, R.drawable.blackcoffee};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocoa);

        backHome = findViewById(R.id.home);
        listView = findViewById(R.id.listView);

        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cocoa.this, HomePage.class);
                startActivity(intent);
            }
        });


        MyAdapter adapter = new MyAdapter(this, cocoaDrinks, recipes, drinksImg);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(getApplicationContext(), "USD 10.15", Toast.LENGTH_SHORT).show();
                }
                if (position == 1) {
                    Toast.makeText(getApplicationContext(), "USD 15.10", Toast.LENGTH_SHORT).show();
                }
                if (position == 2) {
                    Toast.makeText(getApplicationContext(), "USD 18.12", Toast.LENGTH_SHORT).show();
                }
                if (position == 3) {
                    Toast.makeText(getApplicationContext(), "USD 8.12", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }





    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String cocoaDrinks[];
        String recipes[];
        int drinkImg[];

        MyAdapter(Context c,String drinkName[], String drinkRecipe[], int drinkImg[]) {
            super(c, R.layout.row, R.id.textView1, drinkName);
            this.context = c;
            this.cocoaDrinks = drinkName;
            this.recipes = drinkRecipe;
            this.drinkImg = drinkImg;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.drinkImg);
            TextView drinksName = row.findViewById(R.id.textView1);
            TextView drinkRecipe = row.findViewById(R.id.textView2);

            images.setImageResource(drinkImg[position]);
            drinksName.setText(cocoaDrinks[position]);
            drinkRecipe.setText(recipes[position]);
            return row;
        }
    }
}