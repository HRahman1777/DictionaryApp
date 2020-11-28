package com.example.dictionaryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class About extends AppCompatActivity {

    public Button buttonAbout, buttonAother;
    public Fragment myFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        buttonAbout = findViewById(R.id.aboutFragID);
        buttonAother = findViewById(R.id.anotherFragBtnID);


        buttonAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myFragment = new AboutFrag();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentID, myFragment);
                fragmentTransaction.commit();
            }
        });

        buttonAother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myFragment = new AnotherFrag();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentID, myFragment);
                fragmentTransaction.commit();
            }
        });

    }
}
