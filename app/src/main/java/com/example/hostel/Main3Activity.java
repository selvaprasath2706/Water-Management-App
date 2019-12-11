package com.example.hostel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class Main3Activity extends AppCompatActivity {
    FirebaseAuth mAuth;
    String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mAuth=FirebaseAuth.getInstance();
        uid=getIntent().getStringExtra("uid");
    }

    public void left(View view) {
        Intent i=new Intent(Main3Activity.this,Main4Activity.class);
        startActivity(i);
    }

    public void right(View view) {
        Intent i=new Intent(Main3Activity.this,Main5Activity.class);
        startActivity(i);
    }

    public void logout(View view) {
        Intent i=new Intent(Main3Activity.this,Main2Activity.class);
        mAuth.signOut();
        startActivity(i);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(mAuth.getCurrentUser()==null)
        {

            Intent i=new Intent(Main3Activity.this,Main2Activity.class);
            startActivity(i);
        }

    }

}


