package com.CMRCET.sharebit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class HomePage extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    private CardView canteenView, lostAndFoundView, eventsView, cleaningView, registerView;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        canteenView = (CardView) findViewById(R.id.canteenId);
        lostAndFoundView = (CardView) findViewById(R.id.LostnFoundId);
        eventsView = (CardView) findViewById(R.id.eventsId);
        cleaningView = (CardView) findViewById(R.id.cleaningId);
        registerView = (CardView) findViewById(R.id.registerId);
        canteenView.setOnClickListener(this);
        lostAndFoundView.setOnClickListener(this);
        eventsView.setOnClickListener(this);
        cleaningView.setOnClickListener(this);
        registerView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.canteenId:
                i = new Intent(this, Canteen.class);
                startActivity(i);
                break;
            case R.id.LostnFoundId:
                i = new Intent(this, LostAndFound.class);
                startActivity(i);
                break;
            case R.id.eventsId:
                i = new Intent(this, Events.class);
                startActivity(i);
                break;
            case R.id.cleaningId:
                i = new Intent(this, Cleaning.class);
                startActivity(i);
                break;
            case R.id.registerId:
                i = new Intent(HomePage.this, Register.class);
                startActivity(i);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }

    }
}