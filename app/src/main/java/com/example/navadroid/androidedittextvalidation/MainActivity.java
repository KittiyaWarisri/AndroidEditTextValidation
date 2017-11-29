package com.example.navadroid.androidedittextvalidation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick (View v){
        if(v.getId() == R.id.button1) {
            Intent i = new Intent(getApplicationContext(),Option1Activity.class);
            startActivity(i);
        }
        if (v.getId() == R.id.button2){
            Intent i = new Intent(getApplicationContext(),Option2Activity.class);
            startActivity(i);
        }
        if (v.getId() == R.id.button3){
            Intent i = new Intent(getApplicationContext(),Option3Activity.class);
            startActivity(i);
        }

    }


}
