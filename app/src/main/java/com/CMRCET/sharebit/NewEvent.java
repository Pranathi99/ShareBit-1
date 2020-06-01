package com.CMRCET.sharebit;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NewEvent extends AppCompatActivity {
    EditText title;
    EditText details;
    EditText date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_event);
        title=(EditText) findViewById(R.id.eventTitle);
        details=(EditText) findViewById(R.id.eventDetails);
        date=(EditText) findViewById(R.id.eventDate);
        String eventTitle=title.getText().toString();
        String eventDetails=details.getText().toString();
        String eventDate=date.getText().toString();
    }
}


