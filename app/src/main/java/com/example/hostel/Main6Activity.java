package com.example.hostel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main6Activity extends AppCompatActivity {
    DatabaseReference databaseref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        databaseref=FirebaseDatabase.getInstance().getReference("all");
        databaseref.child("left").child("water").setValue("Available");
        databaseref.child("left").child("ground").setValue("Locked");
        databaseref.child("left").child("first").setValue("Locked");
        databaseref.child("left").child("second").setValue("Locked");
        databaseref.child("left").child("third").setValue("Locked");
        Toast.makeText(Main6Activity.this, "Success", Toast.LENGTH_SHORT).show();
        databaseref.child("right").child("water").setValue("Available");
        databaseref.child("right").child("ground").setValue("Locked");
        databaseref.child("right").child("first").setValue("Locked");
        databaseref.child("right").child("second").setValue("Locked");
        databaseref.child("right").child("third").setValue("Locked");
    }
}
