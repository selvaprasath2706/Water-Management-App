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

public class Main8Activity extends AppCompatActivity {
    DatabaseReference databaseReference;
    DatabaseReference databaseReference2;
    DatabaseReference databaseReference3;
    FirebaseAuth mAuth;
    TextView t;
    String uid,role;
    String ground;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        databaseReference= FirebaseDatabase.getInstance().getReference("all");
        databaseReference2= FirebaseDatabase.getInstance().getReference("users");
        databaseReference3= FirebaseDatabase.getInstance().getReference("time");
        mAuth=FirebaseAuth.getInstance();
        uid=mAuth.getUid();
        ground=getIntent().getStringExtra("ground");
        t=findViewById(R.id.textView25);
    }

    public void usergroundchangeleft(View view) {
        databaseReference2.child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                role=dataSnapshot.child("role").getValue().toString();
                if(role.equals("admin")) {

                    AlertDialog.Builder s = new AlertDialog.Builder(Main8Activity.this);
                    s.setTitle("Modify value");
                    s.setMessage("Do you want to change the value");
                    s.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (ground.equals("Locked")) {
                                databaseReference.child("left").child("ground").setValue("Open");
                            } else {
                                databaseReference.child("left").child("ground").setValue("Locked");
                            }
                            Calendar c=Calendar.getInstance();
                            SimpleDateFormat s=new SimpleDateFormat("HH:mm:ss");
                            String date="Last Modified at : "+s.format(c.getTime());
                            databaseReference3.child("left").child("ground").setValue(date);
                            Intent i2 = new Intent(Main8Activity.this, Main4Activity.class);
                            startActivity(i2);
                        }
                    });
                    s.setNegativeButton("no", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent s1 = new Intent(Main8Activity.this, Main4Activity.class);
                            startActivity(s1);
                        }

                    });
                    s.show();
                }

                else
            {
                Toast.makeText(Main8Activity.this, "sorry you dont have the proper rights to perform this " + "action", Toast.LENGTH_SHORT).show();
                Intent s1 = new Intent(Main8Activity.this, Main4Activity.class);
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
                String date= dataSnapshot.child("left").child("ground").getValue().toString();

                t.setText(date);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
