package com.example.dictionaryapp;

import androidx.appcompat.app.AppCompatActivity;

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

    public Button buttonSubmitAP;
    public EditText editTextWordAP, editTextMeaningAP;
    public ListView listViewFeedback;
    DatabaseReference databaseReference;

    public List<UploadFeedbackData> uploadedFeedbackList;  //reDB1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);

        buttonSubmitAP = findViewById(R.id.submit_apBtnID);
        editTextWordAP = findViewById(R.id.word_apETID);
        editTextMeaningAP = findViewById(R.id.mean_apETID);
        listViewFeedback = findViewById(R.id.feedbackListID);

        uploadedFeedbackList = new ArrayList<>(); //reDB2

        databaseReference = FirebaseDatabase.getInstance().getReference("feedback/");
        //retriveingData(); //reDB3

        buttonSubmitAP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strWord = editTextWordAP.getText().toString();
                String strMean = editTextMeaningAP.getText().toString();
                Toast.makeText(getApplicationContext(),"Word: "+strWord+"\nMeaning :"+strMean,Toast.LENGTH_SHORT).show();
            }
        });


        listViewFeedback.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                UploadFeedbackData uploadFeedbackData = uploadedFeedbackList.get(i); //reDB3
                String strW = uploadFeedbackData.getWord();
                String strM = uploadFeedbackData.getMeaning();
                editTextWordAP.setText(strW);
                editTextMeaningAP.setText(strM);
            }
        });



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    UploadFeedbackData uploadFeedbackDataL = postSnapshot.getValue(UploadFeedbackData.class);
                    uploadedFeedbackList.add(uploadFeedbackDataL);
                }

                String[] uploads = new String[uploadedFeedbackList.size()];

                for (int i = 0; i < uploads.length; i++) {
                    uploads[i] = uploadedFeedbackList.get(i).getName();
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, uploads);
                listViewFeedback.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }

}
