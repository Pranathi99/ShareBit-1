package com.CMRCET.sharebit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.util.EventLog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateEvent extends AppCompatActivity {

    EditText title,details,date;
    Button create;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        databaseReference= FirebaseDatabase.getInstance().getReference();
        title=(EditText)findViewById(R.id.eventTitle);
        details=(EditText)findViewById(R.id.eventDetails);
        date=(EditText)findViewById(R.id.eventDate);
        create=(Button)findViewById(R.id.create);
        final String ETitle=title.getText().toString();
        final String EDetails=details.getText().toString();
        final String EDate=date.getText().toString();
        databaseReference.child("Events").setValue("Title");
        databaseReference.child("Events").setValue("Details");
        databaseReference.child("Events").setValue("Date");
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                EventList eventList=new EventList(ETitle,EDetails,EDate);
//                databaseReference.child("Events").push().setValue(eventList);

                databaseReference.child("Events").child("Title").setValue(ETitle);
                databaseReference.child("Events").child("Details").setValue(EDetails);
                databaseReference.child("Events").child("Date").setValue(EDate);
                Toast.makeText(getApplicationContext(),"Event Added",Toast.LENGTH_LONG);
//                Intent i=new Intent(getApplicationContext(),Events.class);
//                startActivity(i);
            }
        });
    }
}