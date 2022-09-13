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

public class Shakes extends AppCompatActivity {

    ImageView backHome;
    ListView listView;
    String shakesDrinks[] = {"STRAWBERRY MILKSHAKE", "CHOCOLATE MILKSHAKE", "BANANA MILKSHAKE", "GRAPE MILKSHAKE"};

    String recipes[] = {"Strawberries, Chilled Milk, Sugar(optional)",
                        "Chocolate, Chilled Milk, Sugar(optional)",
                        "Grinded Banana, Little Warm Milk, Sugar(optional)",
                        "Grinded Grape Fruit, Milk, Sugar(optional)"};

    int drinksImg[] = {R.drawable.strawberry_milkshake, R.drawable.chocolate_milkshake, R.drawable.banana_milkshake, R.drawable.grape_milkshake};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shakes);

        backHome = findViewById(R.id.home);
        listView = findViewById(R.id.listView);

        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Shakes.this, HomePage.class);
                startActivity(intent);
            }
        });


        MyAdapter adapter = new MyAdapter(this, shakesDrinks, recipes, drinksImg);
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
        String shakesDrinks[];
        String recipes[];
        int drinkImg[];

        MyAdapter(Context c,String drinkName[], String drinkRecipe[], int drinkImg[]) {
            super(c, R.layout.row, R.id.textView1, drinkName);
            this.context = c;
            this.shakesDrinks = drinkName;
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
            drinksName.setText(shakesDrinks[position]);
            drinkRecipe.setText(recipes[position]);
            return row;
        }
    }
}