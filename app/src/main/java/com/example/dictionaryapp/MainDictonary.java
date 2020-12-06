package com.example.dictionaryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainDictonary extends AppCompatActivity {

    private ListView listView;
    private TextView textView;
    DatabaseReference databaseReference;
    private List<UploadWordMeaning> uploadWordMeaningList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dictonary);

        textView = findViewById(R.id.wordDetailsTVID);

        listView = findViewById(R.id.mainDictListViewID);

        databaseReference = FirebaseDatabase.getInstance().getReference("word/");
        uploadWordMeaningList = new ArrayList<>();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                UploadWordMeaning uploadWM = uploadWordMeaningList.get(i);
                String string1 = uploadWM.getStrWord();
                String string2 = uploadWM.getStrMeaning();
                String strWordMeaning = "Word: "+string1+"\nMeaning: "+string2;
                textView.setText(strWordMeaning);

            }
        });



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                uploadWordMeaningList.clear();
                for (DataSnapshot dataSnapshotValue : snapshot.getChildren()){
                    UploadWordMeaning uploadWord = dataSnapshotValue.getValue(UploadWordMeaning.class);
                    uploadWordMeaningList.add(uploadWord);
                }

                String[] uploads = new String[uploadWordMeaningList.size()];

                for (int i = 0; i < uploads.length; i++) {
                    uploads[i] = uploadWordMeaningList.get(i).getStrWord();
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
