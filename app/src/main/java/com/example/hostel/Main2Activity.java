package com.example.hostel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main2Activity extends AppCompatActivity {
    TextView t1,t2,t3,t4;
    EditText e1,e2;
    String s1,s2;
    Integer in1;
    DatabaseReference databaseReference;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t1=findViewById(R.id.textView4);
        t2=findViewById(R.id.textView5);
        t3=findViewById(R.id.textView6);
        t4=findViewById(R.id.textView12);
        e1=findViewById(R.id.editText3);
        e2=findViewById(R.id.editText4);
        mAuth=FirebaseAuth.getInstance();

    }
    public void chekuser(View view) {
    s1=e1.getText().toString();
    s2=e2.getText().toString();
    checksignin(s1,s2);
    }

    private void checksignin(String s1, String s2) {
        mAuth.signInWithEmailAndPassword(s1, s2)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent i=new Intent(Main2Activity.this,Main3Activity.class);
                            Toast.makeText(Main2Activity.this, "Login Sucessful", Toast.LENGTH_SHORT).show();
                            String uid=mAuth.getUid();
                            i.putExtra("uid",uid);
                            startActivity(i);
                        } else {
                            Toast.makeText(Main2Activity.this, "Please enter your credintials properly", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    public void Signuppage(View view) {
        Intent i=new Intent(Main2Activity.this,MainActivity.class);
        startActivity(i);
    }
}
