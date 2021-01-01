package com.mdw31g4.covimeds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //declaration champs de formulaire
    EditText e1,e2,e3,e4,e5,e6,e7,e8 ;
    RadioButton r1,r2,r3,r4 ;
    Button b1 , b2;
    //declartaion de base de données
    database db ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new database(this);
        e1 = (EditText)findViewById(R.id.fname);
        e2 = (EditText)findViewById(R.id.user);
        e3 = (EditText)findViewById(R.id.phone);
        e4 = (EditText)findViewById(R.id.gouv);
        e5 = (EditText)findViewById(R.id.region);
        e6 = (EditText)findViewById(R.id.mail);
        e7 = (EditText)findViewById(R.id.pass);
        e8 = (EditText)findViewById(R.id.cpass);
        r1 =(RadioButton)findViewById(R.id.btmen);
        r2 = (RadioButton)findViewById(R.id.btwomen);
        r3 = (RadioButton)findViewById(R.id.pharmaci);
        r4 = (RadioButton)findViewById(R.id.patient);
        b1 = (Button)findViewById(R.id.submit);
        b2 = (Button)findViewById(R.id.log);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Login.class);
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                String s4 = e4.getText().toString();
                String s5 = e5.getText().toString();
                String s6 = e6.getText().toString();
                String s7 = e7.getText().toString();
                String s8 = e8.getText().toString();
                if (s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")||s5.equals("")||s6.equals("")||s7.equals("")||s8.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();

                }
                else {
                    if (s7.equals(s8)){
                        Boolean chkemail = db.chkemail(s6);
                        if (chkemail==true){
                            Boolean insert = db.insert(s1,s2,s3,s4,s5,s6,s7);
                            if(insert==true){
                                Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_SHORT).show();
                            }

                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Email Already exists",Toast.LENGTH_SHORT).show();
                        }
                    }
                }



            }
        });

    }
}