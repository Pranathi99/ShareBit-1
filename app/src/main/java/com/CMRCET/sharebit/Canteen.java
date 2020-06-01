package com.CMRCET.sharebit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Canteen extends AppCompatActivity implements View.OnClickListener{

    private CardView breakfastView,lunchView,snacksView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canteen);
        breakfastView=(CardView)findViewById(R.id.breakfast);
        lunchView=(CardView)findViewById(R.id.lunch);
        snacksView=(CardView)findViewById(R.id.snacks);
        breakfastView.setOnClickListener(this);
        lunchView.setOnClickListener(this);
        snacksView.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.breakfast:
                i = new Intent(this, Breakfast.class);
                startActivity(i);
                break;
            case R.id.lunch:
                i = new Intent(this, Lunch.class);
                startActivity(i);
                break;
            case R.id.snacks:
                i = new Intent(this, Snacks.class);
                startActivity(i);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }
}