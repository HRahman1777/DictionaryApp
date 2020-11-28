package com.example.dictionaryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdminLogin extends AppCompatActivity {

    public Button buttonLogin;
    public EditText editTextUsernm, editTextPasswd;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        buttonLogin = findViewById(R.id.loginBtnID);
        editTextUsernm = findViewById(R.id.usernmETID);
        editTextPasswd = findViewById(R.id.paswdETID);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                databaseReference = FirebaseDatabase.getInstance().getReference("login/");
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String uName = dataSnapshot.child("username").getValue().toString();
                        String uPass = dataSnapshot.child("password").getValue().toString();

                        String strUsnm = editTextUsernm.getText().toString();
                        String strUpass = editTextPasswd.getText().toString();

                        if(strUsnm.equals(uName) && strUpass.equals(uPass)){
                            Intent intent = new Intent((AdminLogin.this) , (AdminPanel.class));
                            startActivity(intent);
                            finish();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Wrong username/password !",Toast.LENGTH_SHORT).show();
                            editTextUsernm.setText(null);
                            editTextPasswd.setText(null);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

    }
}
