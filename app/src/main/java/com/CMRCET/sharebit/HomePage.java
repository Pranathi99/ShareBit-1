package com.CMRCET.sharebit;

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
    }

    @Override
    public void onClick(View v) {

    }
}