package com.CMRCET.sharebit;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NewEvent extends AppCompatActivity {
    EditText title;
    EditText details;
    EditText date;
    String eventTitle;
    String eventDetails;
    String eventDate;
    Button create;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_event);
        title=(EditText) findViewById(R.id.eventTitle);
        details=(EditText) findViewById(R.id.eventDetails);
        date=(EditText) findViewById(R.id.eventDate);
        create= (Button)findViewById(R.id.create);
        eventTitle=title.getText().toString();
        eventDetails=details.getText().toString();
        eventDate=date.getText().toString();

    }
}


