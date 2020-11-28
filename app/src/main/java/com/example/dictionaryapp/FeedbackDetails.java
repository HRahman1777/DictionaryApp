package com.example.dictionaryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FeedbackDetails extends AppCompatActivity {

    private ListView listView;
    private TextView textView;

    DatabaseReference databaseReference;
    private List<UploadFeedbackData> uploadFeedbackDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_details);

        textView = findViewById(R.id.feedbackDetTVID);

        listView = findViewById(R.id.feedbackListViewID);

        databaseReference = FirebaseDatabase.getInstance().getReference("feedback/");
        uploadFeedbackDataList = new ArrayList<>();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                UploadFeedbackData uploadWM = uploadFeedbackDataList.get(i);
                String string1 = uploadWM.getName();
                String string2 = uploadWM.getEmail();
                String string3 = uploadWM.getWord();
                String string4 = uploadWM.getMeaning();
                String string5 = uploadWM.getComment();
                String strFeedbackDet= "Name: "+string1+"\nEmail: "+string2+"\nWord: "+string3+"\nMeaning: "+string4+"\nComment: "+string5;
                textView.setText(strFeedbackDet);
            }
        });


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                uploadFeedbackDataList.clear();
                for (DataSnapshot dataSnapshotValue : snapshot.getChildren()){
                    UploadFeedbackData uploadWord = dataSnapshotValue.getValue(UploadFeedbackData.class);
                    uploadFeedbackDataList.add(uploadWord);
                }

                String[] uploads = new String[uploadFeedbackDataList.size()];

                for (int i = 0; i < uploads.length; i++) {
                    uploads[i] = uploadFeedbackDataList.get(i).getName();
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, uploads);
                listView.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        super.onStart();

    }
}
