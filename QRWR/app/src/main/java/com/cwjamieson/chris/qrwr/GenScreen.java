package com.cwjamieson.chris.qrwr;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class GenScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gen_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //set back button and title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Enter your message");


        //add editText listener to respond to enter
        TextView.OnEditorActionListener enterListener = new TextView.OnEditorActionListener(){
            public boolean onEditorAction(TextView exampleView, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_NULL
                        && event.getAction() == KeyEvent.ACTION_DOWN) {
                    next();
                }
                return true;
            }
        };
        EditText edit = (EditText) findViewById(R.id.edit);
        edit.setOnEditorActionListener(enterListener);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next();
            }
        });
        fab.setImageResource(R.drawable.ic_check);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id==android.R.id.home) {
            finish();
        }
        return true;

    }

    public void next()
    {
        EditText edit = (EditText) findViewById(R.id.edit);
        String out = edit.getText().toString();
        Intent intent = new Intent(this, OutScreen.class);
        intent.putExtra("OUTPUT", out);
        startActivity(intent);
    }

}
