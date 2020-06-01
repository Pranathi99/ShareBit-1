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
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    private EditText fullname,password,clgId,phone,year;
    Button create;
    private FirebaseAuth mAuth;
    protected void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.register);
        fullname=(EditText) findViewById(R.id.regUserName);
        password=(EditText) findViewById(R.id.regPass);
        clgId=(EditText) findViewById(R.id.regId);
        phone=(EditText) findViewById(R.id.regNo);
        year=(EditText) findViewById(R.id.regYr);
        create=(Button) findViewById(R.id.create);

        mAuth=FirebaseAuth.getInstance();
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.create:
                        registerUser();
                        break;
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(mAuth.getCurrentUser()!=null)
        {

        }
    }

    private void registerUser(){
        final String name=clgId.getText().toString().trim();
        final String pass=password.getText().toString().trim();
        final String fname=fullname.getText().toString().trim();
        final String mobileno=phone.getText().toString().trim();
        final String yr=year.getText().toString().trim();

        if(name.isEmpty()){
            clgId.setError("college id required");
            clgId.requestFocus();
            return;
        }
        if(fname.isEmpty()){
            fullname.setError("full name required");
            fullname.requestFocus();
            return;
        }
        if(pass.isEmpty()){
            password.setError("password required");
            password.requestFocus();
            return;
        }
        if(mobileno.length()!=10)
        {
            phone.setError("Enter valid mobile no.");
            phone.requestFocus();
            return;
        }
        if(yr.isEmpty()){
            year.setError("Enter year/dept");
            year.requestFocus();
            return;
        }
        if(pass.length()<6){
            password.setError("Password should be atleast 6 characters long");
            password.requestFocus();
            return;
        }
        String email=name+"@cmrcet.org";
        mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    User user=new User(name,pass,yr,mobileno,fname);
                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(Register.this,getString(R.string.registration_success),Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
                else{
                    Toast.makeText(Register.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
