package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class UserProfile extends AppCompatActivity {

    Button add_tasks, add_med;

    ListView tasks_list, med_listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        add_tasks = findViewById(R.id.add_tasks);
        add_med = findViewById(R.id.add_med);

        add_tasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToTaskPage();
            }
        });

        add_med.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMedPage();
            }
        });

    }

    public void goToTaskPage(){
        Intent intent = new Intent(this, TodoPage.class);
        startActivity(intent);
    }

    public void goToMedPage(){
        Intent intent = new Intent(this, MedsPage.class);
    }
}