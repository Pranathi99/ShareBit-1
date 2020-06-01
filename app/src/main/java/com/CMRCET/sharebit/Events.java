package com.CMRCET.sharebit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class Events extends AppCompatActivity {
    private CardArrayAdapter cardArrayAdapter;
    private ListView listView;
    private Button newEvent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        listView=(ListView)findViewById(R.id.card_listView);
        listView.addHeaderView(new View(this));
        listView.addFooterView(new View(this));
        newEvent=(Button)findViewById(R.id.button);
        cardArrayAdapter=new CardArrayAdapter(getApplicationContext(),R.layout.list_item_card);
        for(int i=0;i<10;i++)
        {
            Cards card=new Cards("Event "+(i+1),"23/01/2000","QWWFE");
            cardArrayAdapter.add(card);
        }
        listView.setAdapter(cardArrayAdapter);
        newEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(getApplicationContext(),NewEvent.class);
                startActivity(in);
            }
        });
    }
}