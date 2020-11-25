package com.example.dictionaryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {

    public Button buttonLogin;
    public EditText editTextUsernm, editTextPasswd;

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

                String strUsnm = editTextUsernm.getText().toString();
                String strPasswd = editTextPasswd.getText().toString();

                if (strUsnm.equals("hasibur") && strPasswd.equals("5h4nt0")){
                    Intent intent;
                    intent = new Intent((AdminLogin.this), (AdminPanel.class));
                    startActivity(intent);
                    editTextUsernm.setText(null);
                    editTextPasswd.setText(null);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Wrong username/password !",Toast.LENGTH_SHORT).show();
                    editTextUsernm.setText(null);
                    editTextPasswd.setText(null);
                }
            }
        });

    }
}
