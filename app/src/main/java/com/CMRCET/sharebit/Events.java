package com.CMRCET.sharebit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Events extends AppCompatActivity implements View.OnClickListener{
    private CardArrayAdapter cardArrayAdapter;
    private ListView listView;
    private FloatingActionButton newEvent;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        listView=(ListView)findViewById(R.id.card_listView);
        listView.addHeaderView(new View(this));
        listView.addFooterView(new View(this));
        newEvent=(FloatingActionButton) findViewById(R.id.button);
        cardArrayAdapter=new CardArrayAdapter(getApplicationContext(),R.layout.list_item_card);
        for(i=1;i<=10;i++)
        {
            Cards card=new Cards("Event "+(i),"23/01/2000","QWWFE");
            cardArrayAdapter.add(card);
        }
        listView.setAdapter(cardArrayAdapter);
        newEvent.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Cards card=new Cards("Event "+(i++),"23/01/2000","QWWFE");
        cardArrayAdapter.add(card);
        listView.setAdapter(cardArrayAdapter);
    }
}