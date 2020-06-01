package com.CMRCET.sharebit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class Breakfast extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);
        // Construct the data source
        ArrayList<Food> arrayOfFoodItems = new ArrayList<Food>();
        arrayOfFoodItems.add(new Food("Puri","3 pieces puri","20"));
        arrayOfFoodItems.add(new Food("Dosa","1 piece dosa","25"));
        arrayOfFoodItems.add(new Food("Bajji","3 pieces bajji","30"));
        arrayOfFoodItems.add(new Food("Onion Dosa","1 piece onion dosa","30"));
        arrayOfFoodItems.add(new Food("Masala Dosa","1 piece masala dosa","40"));
        // Create the adapter to convert the array to views
        FoodAdapter adapter = new FoodAdapter(this, arrayOfFoodItems);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.bflistview);
        listView.setAdapter(adapter);
    }

}