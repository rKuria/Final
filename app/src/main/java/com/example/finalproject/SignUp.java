package com.example.finalproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {

    // references to all the components on the page
    Button button;
    EditText nameValue, emailValue, passwordValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        //assign values to the components
        button = findViewById(R.id.button);
        nameValue = findViewById(R.id.nameValue);
        emailValue = findViewById(R.id.emailValue);
        passwordValue = findViewById(R.id.passwordValue);

        //button onClick listeners
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SignUp.this, "Voila!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
