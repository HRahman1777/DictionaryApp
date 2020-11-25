package com.example.dictionaryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminPanel extends AppCompatActivity {

    public Button buttonSubmitAP;
    public EditText editTextWordAP, editTextMeaningAP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);

        buttonSubmitAP = findViewById(R.id.submit_apBtnID);
        editTextWordAP = findViewById(R.id.word_apETID);
        editTextMeaningAP = findViewById(R.id.mean_apETID);

        buttonSubmitAP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strWord = editTextWordAP.getText().toString();
                String strMean = editTextMeaningAP.getText().toString();
                Toast.makeText(getApplicationContext(),"Word: "+strWord+"\nMeaning :"+strMean,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
