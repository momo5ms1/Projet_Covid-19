package com.mdw31g4.covimeds;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    EditText e1,e2;
    Button b1 ;
    database db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new database(this);
        e1 = (EditText)findViewById(R.id.user);
        e2 = (EditText)findViewById(R.id.editTextPassword);
        b1 = (Button)findViewById(R.id.lo);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}