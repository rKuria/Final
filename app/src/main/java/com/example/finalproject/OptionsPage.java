package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OptionsPage extends AppCompatActivity {

    Button buttonok;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_page);


        buttonok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTodoPage();

                Toast.makeText(OptionsPage.this, "Asa!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void openTodoPage() {
        Intent intent = new Intent(this, TodoPage.class);
        startActivity(intent);
    }
}