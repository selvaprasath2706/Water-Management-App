package com.example.hostel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main5Activity extends AppCompatActivity {
    TextView t1, t2, t3, t4, t5, t6, t7, t8, t9, t10;
    DatabaseReference firebase;
    String water,ground,first,second,third;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        t1 = findViewById(R.id.textView3);
        t2 = findViewById(R.id.textView7);
        t3 = findViewById(R.id.textView8);
        t4 = findViewById(R.id.textView20);
        t5 = findViewById(R.id.textView11);
        t6 = findViewById(R.id.textView13);
        t7 = findViewById(R.id.textView14);
        t8 = findViewById(R.id.textView16);
        t9 = findViewById(R.id.textView17);
        t10 = findViewById(R.id.textView19);
        firebase = FirebaseDatabase.getInstance().getReference("all");
        firebase.child("right").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                water = dataSnapshot.child("water").getValue().toString();
                t2.setText(water);
                ground = dataSnapshot.child("ground").getValue().toString();
                t4.setText(ground);
                first = dataSnapshot.child("first").getValue().toString();
                t6.setText(first);
                second = dataSnapshot.child("second").getValue().toString();
                t8.setText(second);
                third = dataSnapshot.child("first").getValue().toString();
                t10.setText(third);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


    public void backhome(View view) {
        Intent i = new Intent(Main5Activity.this, Main3Activity.class);
        startActivity(i);

    }

    public void torightwater(View view) {
        Intent i=new Intent(Main5Activity.this,Main12Activity.class);
        i.putExtra("water",water);
        startActivity(i);
    }


    public void torightground(View view) {
        Intent i=new Intent(Main5Activity.this,Main13Activity.class);
        i.putExtra("ground",ground);
        startActivity(i);
    }

    public void torightfirst(View view) {
        Intent i=new Intent(Main5Activity.this,Main14Activity.class);
        i.putExtra("first",first);
        startActivity(i);
    }

    public void torightsecond(View view) {
        Intent i=new Intent(Main5Activity.this,Main15Activity.class);
        i.putExtra("second",second);
        startActivity(i);

    }

    public void torightthird(View view) {
        Intent i=new Intent(Main5Activity.this,Main16Activity.class);
        i.putExtra("third",third);
        startActivity(i);

    }


}