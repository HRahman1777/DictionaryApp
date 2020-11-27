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

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public Button buttonLoad, buttonAdmin, buttonFeedback, buttonAboutInt;
    public ListView listView1;
    public TextView textViewShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdmin = findViewById(R.id.adminBtnID);
        buttonLoad = findViewById(R.id.loadBtnID);
        buttonFeedback = findViewById(R.id.feedbackBtnID);
        buttonAboutInt =findViewById(R.id.aboutBtnID);
        textViewShow = findViewById(R.id.showTextID);

        listView1 = findViewById(R.id.listViewID);
        listViewWork();

        buttonAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent((MainActivity.this), (AdminPanel.class)); //mark
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

            }
        });

    }

    private void listViewWork() {
        String[] my_list = {"itemOne", "itemTwo", "itemThree"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, my_list);
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String selectedValue = parent.getItemAtPosition(position).toString();
        textViewShow.setText(selectedValue);
    }
}
