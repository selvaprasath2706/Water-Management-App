package com.example.hostel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    TextView t1,t2,t3,t4;
    EditText e1,e2,e3;
    String s1,s2,s3;
    Integer in1;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth=FirebaseAuth.getInstance();
        e1=findViewById(R.id.editText);
        e2=findViewById(R.id.editText2);
        e3=findViewById(R.id.editText6);
        t1=findViewById(R.id.textView);
        t2=findViewById(R.id.textView2);
        t3=findViewById(R.id.textView10);
        t4=findViewById(R.id.textView9);
        databaseReference= FirebaseDatabase.getInstance().getReference("users");
           }




    public void selva(View view) {
    s1=e1.getText().toString();
    s2=e2.getText().toString();
    s3=e3.getText().toString();
    if(s2.equals(s3)) {
        auth(s1,s2);
    }
    else
    {
        Toast.makeText(MainActivity.this, "Please Enter Both the password same", Toast.LENGTH_SHORT).show();
    }

    }


    private void auth(final String s1, final String s2) {
        mAuth.createUserWithEmailAndPassword(s1, s2)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            databaseReference.child(mAuth.getUid()).child("gmail").setValue(s1);
                            databaseReference.child(mAuth.getUid()).child("role").setValue("student");
                            Toast.makeText(MainActivity.this, "Signup successful", Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(MainActivity.this,Main2Activity.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(MainActivity.this, "Unexpected error please try again with different mailid", Toast.LENGTH_SHORT).show();
                        }

                    }
                });


    }


    public void signin(View view) {
        Intent i=new Intent(MainActivity.this,Main2Activity.class);
        startActivity(i);
    }
}
