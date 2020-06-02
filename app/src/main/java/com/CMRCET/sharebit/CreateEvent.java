package com.CMRCET.sharebit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateEvent extends AppCompatActivity {

    EditText title,details,date;
    Button create;
    private DatabaseReference databaseReference;
    private DatabaseReference databaseReferenceRetrieve;
    EventList eventList;
    public String addTitle,addDetails,addDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Events");
        title=(EditText)findViewById(R.id.eventTitle);
        details=(EditText)findViewById(R.id.eventDetails);
        date=(EditText)findViewById(R.id.eventDate);
        create=(Button)findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //eventList=new EventList(ETitle,EDetails,EDate);
                eventList=new EventList();
                eventList.setTitle(title.getText().toString().trim());
                eventList.setDetails(details.getText().toString().trim());
                eventList.setDate(date.getText().toString().trim());
                databaseReference.push().setValue(eventList);
                Toast.makeText(CreateEvent.this,"Event Added",Toast.LENGTH_LONG).show();
            }
        });
    }
}