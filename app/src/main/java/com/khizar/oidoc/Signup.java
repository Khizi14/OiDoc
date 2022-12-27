package com.khizar.oidoc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();

        Button signupBtn = findViewById(R.id.signupBtn);
        Button backBtn = findViewById(R.id.backBtn);
        EditText usernm = findViewById(R.id.usernm);
        EditText emailid = findViewById(R.id.emaiid);
        EditText pass = findViewById(R.id.pass);
        EditText dob = findViewById(R.id.dob);
        EditText contnm = findViewById(R.id.contnm);


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Write a message to the database
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference(usernm.getText().toString());

                myRef.setValue(pass.getText().toString());
            }
        });
        contnm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Write a message to the database
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference(contnm.getText().toString());

                myRef.setValue(contnm.getText().toString());

            }
        });
        emailid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Write a message to the database
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference(emailid.getText().toString());

                myRef.setValue(emailid.getText().toString());
            }
        });
    }
}
