package com.example.hostel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main7Activity extends AppCompatActivity {
    String water;
    String uid,role;
    FirebaseAuth mAuth;
    DatabaseReference databaseReference;
    DatabaseReference databaseReference2;
    DatabaseReference databaseReference3;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        water=getIntent().getStringExtra("water");
        databaseReference= FirebaseDatabase.getInstance().getReference("all");
        databaseReference2= FirebaseDatabase.getInstance().getReference("users");
        databaseReference3= FirebaseDatabase.getInstance().getReference("time");
        mAuth=FirebaseAuth.getInstance();
        uid=mAuth.getUid();
        t=findViewById(R.id.textView15);
       }

    public void userwaterchange(View view) {
        databaseReference2.child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                role=dataSnapshot.child("role").getValue().toString();
                if(role.equals("admin"))
                {
                    AlertDialog.Builder s = new AlertDialog.Builder(Main7Activity.this);
                    s.setTitle("Modify value");
                    s.setMessage("Do you want to change the value");
                    s.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (water.equals("Available")) {
                                databaseReference.child("left").child("water").setValue("Not Available");
                            } else {
                                databaseReference.child("left").child("water").setValue("Available");
                            }
                            Calendar c=Calendar.getInstance();
                            SimpleDateFormat s=new SimpleDateFormat("HH:mm:ss");
                            String date="Last Modified at :"+s.format(c.getTime());
                            databaseReference3.child("left").child("water").setValue(date);
                            Intent i2 = new Intent(Main7Activity.this, Main4Activity.class);
                            startActivity(i2);
                        }
                    });
                    s.setNegativeButton("no", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent s1 = new Intent(Main7Activity.this, Main4Activity.class);
                            startActivity(s1);
                        }

                    });
                    s.show();

                }
                else
                {
                    Toast.makeText(Main7Activity.this, "Sorry You dont have the proper rights to Change the values in this " + "action", Toast.LENGTH_SHORT).show();
                    Intent s1 = new Intent(Main7Activity.this, Main4Activity.class);
                    startActivity(s1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



                }

    @Override
    protected void onStart() {
        super.onStart();
    databaseReference3.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            String date= dataSnapshot.child("left").child("water").getValue().toString();

            t.setText(date);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });
    }
}
