package com.example.lab9questionmark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureButtons();
    }

    private void configureButtons(){
        configureAddButton();
        configureExitButton();
        configureViewButton();
    }

    private void configureViewButton(){
        Button viewButton = (Button) findViewById(R.id.viewButton);
        viewButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){
                startActivity(new Intent(MainActivity.this, viewExams.class));
            }
        });
    }

    private void configureAddButton(){
        Button viewButton = (Button) findViewById(R.id.insButton);
        viewButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){
                startActivity(new Intent(MainActivity.this, MainScreen.class));
            }
        });
    }

    public void configureExitButton(){
        Button goBack = (Button) findViewById(R.id.exitButton);
        goBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                finish();
                System.exit(0);
            }
        });


    }

}