package com.CMRCET.sharebit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class Lunch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch);
        // Construct the data source
        ArrayList<Food> arrayOfFoodItems = new ArrayList<Food>();
        arrayOfFoodItems.add(new Food("Sambar Rice","1 plate","40"));
        arrayOfFoodItems.add(new Food("Jeera Rice","1 plate","45"));
        arrayOfFoodItems.add(new Food("Veg.Manchuria","1 plate","50"));
        arrayOfFoodItems.add(new Food("Veg.Fried Rice","1 plate","50"));
        arrayOfFoodItems.add(new Food("Veg.Noodles","1 plate","50"));
        // Create the adapter to convert the array to views
        FoodAdapter adapter = new FoodAdapter(this, arrayOfFoodItems);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.lnlistview);
        listView.setAdapter(adapter);
    }

}