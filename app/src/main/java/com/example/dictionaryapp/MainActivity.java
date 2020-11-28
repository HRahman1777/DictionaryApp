package com.example.dictionaryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    public Button buttonLoad, buttonAdmin, buttonFeedback, buttonAboutInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdmin = findViewById(R.id.adminBtnID);
        buttonLoad = findViewById(R.id.dictBtnID);
        buttonFeedback = findViewById(R.id.feedbackBtnID);
        buttonAboutInt =findViewById(R.id.aboutBtnID);


        buttonAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent((MainActivity.this), (AdminLogin.class)); //mark
                startActivity(intent);
            }
        });

        buttonFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent((MainActivity.this), (Feedback.class));
                startActivity(intent);
            }
        });

        buttonAboutInt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent((MainActivity.this), (About.class));
                startActivity(intent);
            }
        });

        buttonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent((MainActivity.this), (MainDictonary.class));
                startActivity(intent);
            }
        });

    }

}
