package com.example.dictionaryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    public Button buttonHome;
    public TextView textViewName, textViewRule, textViewPoint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewName = findViewById(R.id.nameResultID);
        textViewRule = findViewById(R.id.ruleResultID);
        textViewPoint = findViewById(R.id.pointResultID);

        buttonHome = findViewById(R.id.homeBtnID);

        Bundle bundle = getIntent().getExtras();
        String strName = bundle.getString("name");
        String strRule = bundle.getString("ruleSelect");
        int point = bundle.getInt("marks");

        textViewName.setText("NAME: "+strName);
        textViewRule.setText("RULE AS: "+strRule);
        textViewPoint.setText("Point "+point+" out of 5");

        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent((Result.this), (MainActivity.class));
                startActivity(intent);
            }
        });
    }
}
