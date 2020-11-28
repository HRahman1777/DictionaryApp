package com.example.dictionaryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Feedback extends AppCompatActivity {

    public Button buttonSubmitFb;
    public EditText editTextNameFb, editTextEmailFb, editTextWordFb, editTextMeaningFb, editTextCommnet;

    DatabaseReference databaseReference; //db1

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

        databaseReference = FirebaseDatabase.getInstance().getReference("feedback"); //db2

        buttonSubmitFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strName = editTextNameFb.getText().toString();
                String strEmail = editTextEmailFb.getText().toString();
                String strCmt = editTextCommnet.getText().toString();
                String strMean = editTextMeaningFb.getText().toString();
                String strWord = editTextWordFb.getText().toString();
                String key = databaseReference.push().getKey();

                if (strName.equals("") || strCmt.equals("")){
                    Toast.makeText(getApplicationContext(),"Please enter at least name and comment!",Toast.LENGTH_SHORT).show();
                }else {
                    //db3
                    UploadFeedbackData uploadFeedbackData = new UploadFeedbackData(strName, strEmail, strWord, strMean, strCmt);
                    databaseReference.child(key).setValue(uploadFeedbackData); //db4
                    Toast.makeText(getApplicationContext(),"Thanks For Feedback!",Toast.LENGTH_SHORT).show();
                    editTextWordFb.setText(null);
                    editTextMeaningFb.setText(null);
                    editTextCommnet.setText(null);
                }
            }
        });

    }
}
