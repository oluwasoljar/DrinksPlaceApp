package com.example.drinksapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AllDrinks extends AppCompatActivity {

    ListView listView;

    int images[] = {R.drawable.latte, R.drawable.cappuccino, R.drawable.filter, R.drawable.blackcoffee,
                    R.drawable.strawberry_milkshake, R.drawable.chocolate_milkshake, R.drawable.banana_milkshake, R.drawable.grape_milkshake,
                    R.drawable.cocacola, R.drawable.fanta, R.drawable.sprite, R.drawable.pepsi,
                    R.drawable.arnold_palmer, R.drawable.roy, R.drawable.pina_coladar, R.drawable.shirley,
                    R.drawable.kunu, R.drawable.pito, R.drawable.zobo, R.drawable.fura};

    String names[] = {"LATTE", "CAPPUCCINO", "FILTER", "BLACK COFFEE",
                      "STRAWBERRY MILKSHAKE", "CHOCOLATE MILKSHAKE", "BANANA MILKSHAKE", "GRAPE MILKSHAKE",
                      "COCACOLA", "FANTA", "SPRITE", "PEPSI",
                      "ARNOLD PALMER", "ROY ROGERS", "PINA COLADA", "SHIRLEY TEMPLE",
                      "KUNU", "PITO", "ZOBO", "FURA"};

    String desc[] = {"The coffee is usually a strongly-brewed coffee or espresso. And the milk is steamed to make foam. A latte without foam is known as a Flat Whiter",
                     "A cappuccino is an Italian coffee drink that is traditionally prepared with equal parts double espresso, steamed milk, and steamed milk foam on top. Cream may be used instead of milk.",
                     "The filter coffee is traditionally served in small steel tumbler and cup that is used to cool and mix the coffee, this creates the classic frothy layer over the filter coffe",
                     "Black coffee is much healthier than regular milk coffee, with many health properties in them like, rich in antioxidants, helps in weight loss, good for heart, cleanses stomach, Good for liver, improves memory",

                     "Strawberry milkshake is a refreshing healthy strawberry fruit drink to recharge your energy levels. Good for kids as well as a breakfast beverage",
                     "Chocolate milkshakes are loaded with calcium and antioxidants, so you don't have to feel too guilty about your weekly milkshake habit.",
                     "With no snack time complete without this sweet milk, banana milkshake still tops our list of breakfast and snack time menu list.",
                     "Grapes are sour and sweet and contain, vitamin C (ascorbic acid) which tends to spoil milk or curdle milk. A little milk added isn't too bad though.",

                     "The drink Coca-Cola was originated in 1886 by an Atlanta pharmacist, John S. Pemberton (1831–88), at his Pemberton Chemical Company",
                     "Bright, bubbly and popular, Fanta is the soft drink that intensifies fun. Introduced in 1940, Fanta is the second oldest brand of The Coca-Cola Company. Fanta is the soft drink that intensifies fun.",
                     "Sprite is a colorless, lemon and lime-flavored soft drink created by The Coca-Cola Company. It was first developed in West Germany in 1959 as Fanta Klare Zitrone i.e Clear Lemon Fanta",
                     "Pepsi is a carbonated soft drink manufactured by PepsiCo. Originally created and developed in 1893 by Caleb Bradham and introduced as Brad's Drink, it was renamed as Pepsi-Cola in 1898, and then shortened to Pepsi in 1961.",

                     "The Arnold Palmer is a name commonly used for a non-alcoholic beverage that combines iced tea and lemonade. The name refers to the professional American golfer Arnold Palmer, who was known to often request and drink this beverage combination",
                     "A Roy Rogers is a non-alcoholic mixed drink made with cola and grenadine syrup, garnished with a maraschino cherry. The drink's lack of alcoholic content allows it to be served to people who do not drink alcohol as a mocktail. it is named after the actor and singer Roy Rogers",
                     "The piña colada is a sweet cocktail made with rum, cream of coconut or coconut milk, and pineapple juice, usually served either blended or shaken with ice. It may be garnished with either a pineapple wedge, maraschino cherry, or both.",
                     "A Shirley Temple is a non-alcoholic mixed drink traditionally made with ginger ale and a splash of grenadine, garnished with a maraschino cherry",

                     "As a grain based beverage Kunu is a member of the Horchata family. The variety of the drink made from sorghum is a milky light-brown colour, whilst that which is made from millet and maize is whitish in colour",
                     "Pito is a local Nigerian beverage made from either fermented crushed corn (Usually the top clear liquid) sieved out from pap, sorghum or a mixture of both",
                     "Zobo (Zoborodo) is a Nigerian beverage made from dried Roselle plant flowers. The drink is also known as Roselle drink and called Sorrel drink in the Carribean",
                     "It is a drink made from millet or sorghum, fura can be mixed with yoghurt and is taken in most West African countries including Nigeria and Ghana"};

    List<AllDrinksModel> listItems = new ArrayList<>();

    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_drinks);

        listView = findViewById(R.id.listView);

        for(int i = 0; i < names.length; i++) {
            AllDrinksModel allDrinksModel = new AllDrinksModel(names[i], desc[i], images[i]);
            listItems.add(allDrinksModel);
        }

        customAdapter = new CustomAdapter(listItems,this);
        listView.setAdapter(customAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem menuItem = menu.findItem(R.id.search_view);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                customAdapter.getFilter().filter(newText);
                return true;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.search_view) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class CustomAdapter extends BaseAdapter implements Filterable {

        private List<AllDrinksModel> allDrinksModelList;
        private List<AllDrinksModel> allDrinksModelListFiltered;
        private Context context;

        public CustomAdapter(List<AllDrinksModel> allDrinksModelList, Context context) {
            this.allDrinksModelList = allDrinksModelList;
            this.allDrinksModelListFiltered = allDrinksModelList;
            this.context = context;
        }

        @Override
        public int getCount() {
            return allDrinksModelListFiltered.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.row_items, null);
            ImageView imageView = view.findViewById(R.id.imageView);
            TextView itemName = view.findViewById(R.id.itemName);
            TextView itemDesc = view.findViewById(R.id.itemDesc);

            imageView.setImageResource(allDrinksModelListFiltered.get(position).getImage());
            itemName.setText(allDrinksModelListFiltered.get(position).getName());
            itemDesc.setText(allDrinksModelListFiltered.get(position).getDesc());

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(AllDrinks.this, ItemView.class).putExtra("item",
                            (Serializable)allDrinksModelListFiltered.get(position)));
                }
            });

            return view;
        }

        @Override
        public Filter getFilter() {
            Filter filter = new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence constraint) {

                    FilterResults filterResults = new FilterResults();

                    if (constraint == null || constraint.length() == 0 ) {
                        filterResults.count = allDrinksModelList.size();
                        filterResults.values = allDrinksModelList;
                    } else {

                        List<AllDrinksModel> resultData = new ArrayList<>();
                        String searchStr = constraint.toString();

                        for (AllDrinksModel allDrinksModel: allDrinksModelList) {
                            if (allDrinksModel.getName().toLowerCase().contains(searchStr.toLowerCase())) {
                                resultData.add(allDrinksModel);
                            }
                            filterResults.count = resultData.size();
                            filterResults.values = resultData;
                        }
                    }

                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {
                    allDrinksModelListFiltered = (List<AllDrinksModel>) results.values;

                    notifyDataSetChanged();
                }
            };
            return filter;
        }
    }
}