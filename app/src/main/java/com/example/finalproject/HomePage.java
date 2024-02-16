package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {

    Button button_h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        button_h = findViewById(R.id.button_h);


        //OnClick Listeners
        button_h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignUpPage();

                Toast.makeText(HomePage.this, "It Worked!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void openSignUpPage(){
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }
}