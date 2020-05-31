package com.CMRCET.sharebit;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class HomePage extends AppCompatActivity implements View.OnClickListener{

    private CardView canteenView,lostAndFoundView,eventsView,cleaningView,registerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        canteenView = (CardView)findViewById(R.id.canteenId);
        lostAndFoundView = (CardView)findViewById(R.id.LostnFoundId);
        eventsView = (CardView)findViewById(R.id.eventsId);
        cleaningView = (CardView)findViewById(R.id.cleaningId);
        registerView = (CardView)findViewById(R.id.registerId);
        canteenView.setOnClickListener(this);
        lostAndFoundView.setOnClickListener(this);
        eventsView.setOnClickListener(this);
        cleaningView.setOnClickListener(this);
        registerView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.canteenId:
                i = new Intent(this,Canteen.class);
                break;
            case R.id.LostnFoundId:
                i = new Intent(this,LostAndFound.class);
                break;
            case R.id.eventsId:
                i = new Intent(this,Events.class);
                break;
            case R.id.cleaningId:
                i = new Intent(this,Cleaning.class);
                break;
            case R.id.registerId:
                i = new Intent(this,Register.class);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
        startActivity(i);
    }
}