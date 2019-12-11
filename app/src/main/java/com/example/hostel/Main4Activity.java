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

public class Main4Activity extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    String water,ground,first,second,third;
    DatabaseReference firebaseDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        t1=findViewById(R.id.textView21);
        t2=findViewById(R.id.textView23);
        t3=findViewById(R.id.textView24);
        t4=findViewById(R.id.textView26);
        t5=findViewById(R.id.textView27);
        t6=findViewById(R.id.textView29);
        t7=findViewById(R.id.textView30);
        t8=findViewById(R.id.textView33);
        t9=findViewById(R.id.textView34);
        t10=findViewById(R.id.textView36);
        firebaseDatabase=FirebaseDatabase.getInstance().getReference("all");
        firebaseDatabase.child("left").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                water=dataSnapshot.child("water").getValue().toString();
                t2.setText(water);
                ground=dataSnapshot.child("ground").getValue().toString();
                t4.setText(ground);
                first=dataSnapshot.child("first").getValue().toString();
                t6.setText(first);
                second=dataSnapshot.child("second").getValue().toString();
                t8.setText(second);
                third=dataSnapshot.child("third").getValue().toString();
                t10.setText(third);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void backhomechoose(View view) {
        Intent i=new Intent(Main4Activity.this,Main3Activity.class);
        startActivity(i);
    }

    public void toleftwater(View view) {
        Intent i=new Intent(Main4Activity.this,Main7Activity.class);
        i.putExtra("water",water);
        startActivity(i);
    }

    public void toleftground(View view) {
        Intent i=new Intent(Main4Activity.this,Main8Activity.class);
        i.putExtra("ground",ground);
        startActivity(i);
    }

    public void toleftfirst(View view) {
        Intent i=new Intent(Main4Activity.this,Main9Activity.class);
        i.putExtra("first",first);
        startActivity(i);
    }

    public void toleftsecond(View view) {
        Intent i=new Intent(Main4Activity.this,Main10Activity.class);
        i.putExtra("second",second);

        startActivity(i);
    }

    public void toleftthird(View view) {
        Intent i=new Intent(Main4Activity.this,Main11Activity.class);
        i.putExtra("third",third);
        startActivity(i);
    }
}
