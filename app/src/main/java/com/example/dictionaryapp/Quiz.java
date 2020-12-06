package com.example.dictionaryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    public Button submitBtnQuiz;
    public Spinner spinner;
    public RadioButton radioButtonOne, radioButtonTwo, radioButtonThree, radioButtonFour, radioButtonFive,
    radioButtonSix, radioButtonSeven, radioButtonEight, radioButtonNine, radioButtonTen;

    //public TextView textViewOne, textViewTwo, textViewThree, textViewFour, textViewFive;

    public EditText editTextNameExmne;

    public String strRuleas="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        submitBtnQuiz = findViewById(R.id.submitQuizBtnID);
        editTextNameExmne = findViewById(R.id.nameETquizID);

        radioButtonOne = findViewById(R.id.radioBtnOneID);
        radioButtonTwo = findViewById(R.id.radioBtnTwoID);
        radioButtonThree = findViewById(R.id.radioBtnThreeID);
        radioButtonFour = findViewById(R.id.radioBtnFourID);
        radioButtonFive = findViewById(R.id.radioBtnFiveID);
        radioButtonSix = findViewById(R.id.radioBtnSixID);
        radioButtonSeven = findViewById(R.id.radioBtnSevenID);
        radioButtonEight = findViewById(R.id.radioBtnEightID);
        radioButtonNine = findViewById(R.id.radioBtnNineID);
        radioButtonTen = findViewById(R.id.radioBtnTenID);
/*
        textViewOne = findViewById(R.id.quesOneID);
        textViewTwo = findViewById(R.id.quesTwoID);
        textViewThree = findViewById(R.id.quesThreeID);
        textViewFour = findViewById(R.id.quesFourID);
        textViewFive = findViewById(R.id.quesFiveID);
*/
        spinner = findViewById(R.id.spinnerID);
        ArrayAdapter<CharSequence>myArrayAdapter;
        myArrayAdapter = ArrayAdapter.createFromResource(this, R.array.rule_as, android.R.layout.simple_spinner_item);
        spinner.setAdapter(myArrayAdapter);
        spinner.setOnItemSelectedListener(this);



        submitBtnQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count=0;

                if (radioButtonOne.isChecked()) {
                    count++;
                }
                if (radioButtonFour.isChecked()){
                    count++;
                }
                if (radioButtonFive.isChecked()){
                    count++;
                }
                if (radioButtonEight.isChecked()){
                    count++;
                }
                if (radioButtonNine.isChecked()){
                    count++;
                }

                String strName;
                strName = editTextNameExmne.getText().toString();
                if (strName.equals("")){
                    Toast.makeText(getApplicationContext(),"Please Enter Name!",Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent((Quiz.this),(Result.class));
                    intent.putExtra("name",strName);
                    intent.putExtra("marks",count);
                    intent.putExtra("ruleSelect",strRuleas);
                    startActivity(intent);
                }
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedValue = parent.getItemAtPosition(position).toString();
        if (selectedValue.equals("Student")) {
            strRuleas = selectedValue;
        } else if (selectedValue.equals("Guest")) {
            strRuleas = selectedValue;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
