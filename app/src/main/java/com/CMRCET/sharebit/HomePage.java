package com.CMRCET.sharebit;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
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
                Query query = ref.child("Users").child("username").equalTo(FirebaseAuth.getInstance().getCurrentUser().getUid());
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            i = new Intent(HomePage.this, Register.class);
                            startActivity(i);
                        }
                        else {
                            Toast.makeText(HomePage.this, "Access denied!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }

    }
}