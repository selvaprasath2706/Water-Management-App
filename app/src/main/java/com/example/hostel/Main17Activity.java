package com.example.hostel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main17Activity extends AppCompatActivity {
    TextView t1,t2;
    EditText e1,e2;
    String uid,access;
    DatabaseReference database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main17);
        t1=findViewById(R.id.textView16);
        t2=findViewById(R.id.textView22);
        e1=findViewById(R.id.editText81);
        e2=findViewById(R.id.editText82);
        database=FirebaseDatabase.getInstance().getReference("users");
       }


    public void authorize(View view) {
        uid=e1.getText().toString();
        access=e2.getText().toString();
        database.child(uid).child("role").setValue(access);
        Toast.makeText(Main17Activity.this, "yep done", Toast.LENGTH_SHORT).show();
    }
}
