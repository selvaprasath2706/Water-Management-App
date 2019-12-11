package com.example.hostel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
import java.util.Date;

public class basictest extends AppCompatActivity {
    TextView textView;
    DatabaseReference databaseReference;
    String role;
    String uid;
    final String selva = null;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basictest);
        Calendar c=Calendar.getInstance();
        textView=findViewById(R.id.textView18);
        SimpleDateFormat s=new SimpleDateFormat("HH:MM:SS");
        String date="Current time"+s.format(c.getTime());
        textView.setText(date);

    }

}

