package com.CMRCET.sharebit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;
import java.util.List;

public class Events extends AppCompatActivity{
    private CardArrayAdapter cardArrayAdapter;
    private ListView listView;
    private FloatingActionButton newEvent;
    TextView text;
    public List<Cards> eventList= new LinkedList<Cards>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        listView=(ListView)findViewById(R.id.card_listView);
        listView.addHeaderView(new View(this));
        listView.addFooterView(new View(this));
        newEvent=(FloatingActionButton) findViewById(R.id.button);
        cardArrayAdapter=new CardArrayAdapter(getApplicationContext(),R.layout.list_item_card);
//        Cards c1=new Cards("Event 1","19/01","Event");
//        eventList.add(c1);
        if(eventList.isEmpty())
        {
            text=(TextView)findViewById(R.id.textView);
            text.setText(R.string.no_events);
        }
        for(Cards c:eventList)
        {
            Cards card=new Cards(c.getEventTitle(),c.getEventDate(),c.getEventDetails());
            cardArrayAdapter.add(card);
        }
        listView.setAdapter(cardArrayAdapter);
//        newEvent.setOnClickListener(this);
        newEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),CreateEvent.class);
                startActivity(i);
            }
        });
    }

//    @Override
//    public void onClick(View v) {
//
//        Intent i=new Intent(this,CreateEvent.class);
//        startActivity(i);
//
//
//    }
}