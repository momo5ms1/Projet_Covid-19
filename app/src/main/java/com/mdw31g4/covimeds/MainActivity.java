package com.mdw31g4.covimeds;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText email , password ;
    private CardView login;
    private TextView register;
    DatabaseHelper db ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        email=findViewById(R.id.username);
        password=findViewById(R.id.password) ;
        login=findViewById(R.id.btnLogin) ;
        db=new DatabaseHelper(this);

        register=findViewById(R.id.goRegister);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Register.class);
                startActivity(intent);
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = email.getText().toString();
                String Password = password.getText().toString();

                boolean checkEmailAndPassword=db.checkEmailAndPassword(Email,Password) ;
                if (Email.equals("") || Password.equals("")) {
                    Toast.makeText(getApplicationContext(), "field are empty", Toast.LENGTH_SHORT).show();

                } else {
                    if (checkEmailAndPassword) {

                        Toast.makeText(getApplicationContext(), " Wrong  Email or password ", Toast.LENGTH_SHORT).show();
                    } else {

                        Toast.makeText(getApplicationContext(), "Login Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(), ContactActivity.class) ;
                        startActivity(intent);
                        //comment
                    }

                }
            }
        }) ;

    }
}