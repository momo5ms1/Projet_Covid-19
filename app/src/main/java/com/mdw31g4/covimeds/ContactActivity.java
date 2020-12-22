package com.mdw31g4.covimeds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ContactActivity extends AppCompatActivity {
EditText firstname, lastname, address, age, message;
Button button ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);
        firstname = (EditText) findViewById(R.id.firstname) ;
        lastname= (EditText) findViewById(R.id.lastname) ;
        address = (EditText) findViewById(R.id.address) ;
        age = (EditText) findViewById(R.id.age) ;
        message= (EditText) findViewById(R.id.message) ;
        button = (Button) findViewById(R.id.button) ;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firstname.getText().toString().isEmpty() ||
                        lastname.getText().toString().isEmpty() ||
                        address.getText().toString().isEmpty() ||
                        age.getText().toString().isEmpty() ||
                        message.getText().toString().isEmpty()) {
                    Toast.makeText(ContactActivity.this, "please fill all the blanks", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(getApplicationContext(), ThankyouActivity.class));
                }
            }
        });
    }

}