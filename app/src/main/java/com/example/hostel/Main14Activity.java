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

public class Main14Activity extends AppCompatActivity {
    DatabaseReference databaseReference;
    String first;
    DatabaseReference databaseReference2;
    DatabaseReference databaseReference3;
    TextView t;
    FirebaseAuth mAuth;
    String uid,role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main14);
        mAuth=FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference("all");
        first=getIntent().getStringExtra("first");
        t=findViewById(R.id.textView37);
        databaseReference2= FirebaseDatabase.getInstance().getReference("users");
        databaseReference3= FirebaseDatabase.getInstance().getReference("time");
        uid=mAuth.getUid();
    }

    public void userfirstchangeright(View view) {
        databaseReference2.child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                role=dataSnapshot.child("role").getValue().toString();
                if(role.equals("admin")) {

        AlertDialog.Builder s=new AlertDialog.Builder(Main14Activity.this);
        s.setTitle("Modify value");
        s.setMessage("Do you want to change the value");
        s.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(first.equals("Locked"))
                {
                    databaseReference.child("right").child("first").setValue("Open");
                }
                else
                {
                    databaseReference.child("right").child("first").setValue("Locked");
                }
                Calendar c=Calendar.getInstance();
                SimpleDateFormat s=new SimpleDateFormat("HH:mm:ss");
                String date="Last Modified at :"+s.format(c.getTime());
                databaseReference3.child("right").child("first").setValue(date);
                Intent i2=new Intent(Main14Activity.this,Main5Activity.class);
                startActivity(i2);
            }
        });
        s.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent s1=new Intent(Main14Activity.this,Main5Activity.class);
                startActivity(s1);
            }

        });
        s.show();
    }

                else
    {
        Toast.makeText(Main14Activity.this, "Sorry You dont have the proper rights to Change the values in this " + "action", Toast.LENGTH_SHORT).show();
        Intent s1 = new Intent(Main14Activity.this, Main5Activity.class);
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
                String date= dataSnapshot.child("right").child("first").getValue().toString();

                t.setText(date);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


}



