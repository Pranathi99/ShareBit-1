package com.CMRCET.sharebit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class FoodAdapter extends ArrayAdapter<Food> implements View.OnClickListener {

    private int quantity = 0;

    public FoodAdapter(Context context, ArrayList<Food> foods) {
        super(context, 0, foods);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Food food = getItem(position);
        quantity = 0;
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_menu_items, parent, false);
        }
        // Lookup view for data population
        TextView foodItemName = (TextView) convertView.findViewById(R.id.fooditemname);
        TextView foodItemDesc = (TextView) convertView.findViewById(R.id.fooditemdesc);
        TextView foodItemPrice = (TextView) convertView.findViewById(R.id.fooditemprice);
        ImageView plus = (ImageView) convertView.findViewById(R.id.plus);
        ImageView minus = (ImageView) convertView.findViewById(R.id.minus);
        // Populate the data into the template view using the data object
        foodItemName.setText(food.getName());
        foodItemDesc.setText(food.getDescription());
        foodItemPrice.setText(food.getPrice());
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        // Return the completed view to render on screen
        return convertView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.plus:
                quantity++;
                break;
            case R.id.minus:
                if (quantity - 1 != 0) {
                    quantity--;
                }
                break;
        }
    }
}
