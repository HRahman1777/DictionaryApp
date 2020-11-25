package com.example.dictionaryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {

    public Button buttonSubmitFb;
    public EditText editTextNameFb, editTextEmailFb, editTextWordFb, editTextMeaningFb, editTextCommnet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        buttonSubmitFb = findViewById(R.id.submitfbBtnID);
        editTextNameFb = findViewById(R.id.nameETID);
        editTextEmailFb = findViewById(R.id.emailETID);
        editTextWordFb = findViewById(R.id.wordETID);
        editTextMeaningFb = findViewById(R.id.meanETID);
        editTextCommnet = findViewById(R.id.commentETID);

        buttonSubmitFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strName = editTextNameFb.getText().toString();
                String strEmail = editTextEmailFb.getText().toString();
                String strCmt = editTextCommnet.getText().toString();
                String strMean = editTextMeaningFb.getText().toString();
                String strWord = editTextWordFb.getText().toString();
                Toast.makeText(getApplicationContext(),"Word: "+strWord+"\nMeaning :"+strMean,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
