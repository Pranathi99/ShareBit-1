package com.CMRCET.sharebit;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class CreateEvent extends AppCompatActivity {
    EditText title, details, date;
    Button create;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_event);
        title = (EditText) findViewById(R.id.eventTitle);
        details = (EditText) findViewById(R.id.eventDetails);
        date = (EditText) findViewById(R.id.eventDate);
        create = (Button) findViewById(R.id.create);

        create.setOnClickListener(new View.OnClickListener() {
            final String ETitle = title.getText().toString();
            final String EDetails = details.getText().toString();
            final String EDate = date.getText().toString();

            @Override
            public void onClick(View view) {

                if (mAuth.getCurrentUser().getUid() == "LNc6VVGcZGbPb3uNTfp2t6VquJv1") {
                    EventData eventData = new EventData(ETitle, EDetails, EDate);
                    FirebaseDatabase.getInstance().getReference("Events")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(eventData)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(CreateEvent.this, "Event inserted", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                } else {
                    Toast.makeText(CreateEvent.this, "Access Denied!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

