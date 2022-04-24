package com.example.lab9questionmark;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainScreen extends AppCompatActivity {

    public DBHandler database = new DBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        configChangeToMainScreen();
        configChangeToViewExams();
        configSubmitExam();
    }

    public void configChangeToMainScreen(){
        Button goBack = (Button) findViewById(R.id.backButton);
        goBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                startActivity(new Intent(MainScreen.this, MainActivity.class));
            }
        });


    }

    public void configChangeToViewExams(){
        Button goBack = (Button) findViewById(R.id.viewExamsButton);
        goBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                startActivity(new Intent(MainScreen.this, viewExams.class));
            }
        });


    }


    public void configSubmitExam(){
        Button submitData = (Button) findViewById(R.id.submitButton);
        EditText course = (EditText) findViewById(R.id.editTextTextPersonName);
        EditText selfEval = (EditText) findViewById(R.id.editSelfEval);
        EditText classmateEval = (EditText) findViewById(R.id.editCollEval);
        EditText teacherEval = (EditText) findViewById(R.id.editTeacherEval);
        EditText examDate = (EditText) findViewById(R.id.editExamDate);
        EditText nbLectures = (EditText) findViewById(R.id.editNbOfLec);
        EditText timePerLecture = (EditText) findViewById(R.id.editTimeNeededPerLecture);
        EditText observations = (EditText) findViewById(R.id.editObservations);
        EditText timeForOtherMaterials = (EditText) findViewById(R.id.editTimeForOtherMaterial);
        submitData.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                database.addExam(course.getText().toString(),examDate.getText().toString(),selfEval.getText().toString(),
                        classmateEval.getText().toString(),teacherEval.getText().toString(),nbLectures.getText().toString(),
                        timePerLecture.getText().toString(),timeForOtherMaterials.getText().toString(),observations.getText().toString());
                course.setText("");
                selfEval.setText("");
                classmateEval.setText("");
                teacherEval.setText("");
                examDate.setText("");
                nbLectures.setText("");
                timePerLecture.setText("");
                observations.setText("");
                timeForOtherMaterials.setText("");


            }
        });

    }

}