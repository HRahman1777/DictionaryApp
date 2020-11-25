package com.example.dictionaryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Fragment fragment1, fragment2;
    public Button buttonLoad, buttonAdmin, buttonFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //fragment1 = findViewById(R.id.fragmentID1);
        //fragment2 = findViewById(R.id.fragmentID2);
        buttonAdmin = findViewById(R.id.adminBtnID);
        buttonLoad = findViewById(R.id.loadBtnID);
        buttonFeedback = findViewById(R.id.feedbackBtnID);

        buttonAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent((MainActivity.this), (AdminLogin.class));
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

        buttonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
