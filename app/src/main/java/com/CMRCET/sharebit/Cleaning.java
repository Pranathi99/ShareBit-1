package com.CMRCET.sharebit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Cleaning extends AppCompatActivity {

    EditText Depar;
    EditText ram;
    EditText prblm;
    Button sub;
    Button shw;

    FirebaseDatabase rootNode;
    DatabaseReference reff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleaning);

        Depar = findViewById(R.id.Department);
        ram = findViewById(R.id.RoomNo);
        prblm = findViewById(R.id.Problem);
        sub = findViewById(R.id.submit);
        shw = findViewById(R.id.show);

        rootNode = FirebaseDatabase.getInstance();
        reff = rootNode.getReferenceFromUrl("https://sharebit-3c8ec.firebaseio.com/clean");

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String depart = Depar.getEditableText().toString();
                String rom = ram.getEditableText().toString();
                String pbm = prblm.getEditableText().toString();

                UserHelper helper = new UserHelper(depart,rom,pbm);

                reff.child(pbm).setValue(helper);
                Toast.makeText(Cleaning.this,"Complaint submitted",Toast.LENGTH_SHORT).show();

            }
        });

        shw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),
                        MainActivity4.class);
                startActivity(i);
            }
        });

    }
}