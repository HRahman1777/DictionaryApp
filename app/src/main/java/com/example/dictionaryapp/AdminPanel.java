package com.example.dictionaryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AdminPanel extends AppCompatActivity {

    public Button buttonSubmitAP, buttonFeedbackAP;
    public EditText editTextWordAP, editTextMeaningAP;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);

        buttonSubmitAP = findViewById(R.id.submit_apBtnID);
        buttonFeedbackAP = findViewById(R.id.feedback_apBtnID);
        editTextWordAP = findViewById(R.id.word_apETID);
        editTextMeaningAP = findViewById(R.id.mean_apETID);

        databaseReference = FirebaseDatabase.getInstance().getReference("word");

        buttonSubmitAP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strW = editTextWordAP.getText().toString();
                String strM = editTextMeaningAP.getText().toString();


                if (strW.equals("") || strM.equals("")){
                    Toast.makeText(getApplicationContext(),"Please Enter Value Properly!",Toast.LENGTH_SHORT).show();
                }else{
                    String key = editTextWordAP.getText().toString().toLowerCase();

                    UploadWordMeaning uploadWordMeaning = new UploadWordMeaning(strW, strM);
                    databaseReference.child(key).setValue(uploadWordMeaning);
                    Toast.makeText(getApplicationContext(),"Upload successful !",Toast.LENGTH_SHORT).show();
                    editTextWordAP.setText(null);
                    editTextMeaningAP.setText(null);
                }


            }
        });
        buttonFeedbackAP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent((AdminPanel.this), (FeedbackDetails.class));
                startActivity(intent);
            }
        });

    }


}
