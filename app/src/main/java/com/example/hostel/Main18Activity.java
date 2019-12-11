package com.example.hostel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main18Activity extends AppCompatActivity {
    DatabaseReference databaseReference3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main18);
        databaseReference3= FirebaseDatabase.getInstance().getReference("time");

    }

    public void create(View view) {
        Calendar c=Calendar.getInstance();
        SimpleDateFormat s=new SimpleDateFormat("HH:mm:ss");
        String date="Last Modified at : "+s.format(c.getTime());
        databaseReference3.child("left").child("water").setValue(date);
        databaseReference3.child("left").child("ground").setValue(date);
        databaseReference3.child("left").child("first").setValue(date);
        databaseReference3.child("left").child("second").setValue(date);
        databaseReference3.child("left").child("third").setValue(date);
        databaseReference3.child("right").child("water").setValue(date);
        databaseReference3.child("right").child("ground").setValue(date);
        databaseReference3.child("right").child("first").setValue(date);
        databaseReference3.child("right").child("second").setValue(date);
        databaseReference3.child("right").child("third").setValue(date);
    }

}
