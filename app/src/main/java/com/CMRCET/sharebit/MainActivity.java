package com.CMRCET.sharebit;

import android.content.Intent;
import android.os.Bundle;
<<<<<<< HEAD
||||||| f6f4f79

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

=======
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
>>>>>>> c5f7d85e5ae475478a7a3807d3222128b7302bf2
import androidx.appcompat.app.AppCompatActivity;
<<<<<<< HEAD
||||||| f6f4f79
import androidx.appcompat.widget.Toolbar;

=======
import androidx.appcompat.widget.Toolbar;
>>>>>>> c5f7d85e5ae475478a7a3807d3222128b7302bf2
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
<<<<<<< HEAD
import android.widget.Button;
||||||| f6f4f79
=======
import android.widget.Button;
import android.widget.EditText;
>>>>>>> c5f7d85e5ae475478a7a3807d3222128b7302bf2

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD
        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(getApplicationContext(), HomePage.class);
                // sending data to new activity
                startActivity(i);
            }
        });
||||||| f6f4f79
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
=======
>>>>>>> c5f7d85e5ae475478a7a3807d3222128b7302bf2
    }

@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}