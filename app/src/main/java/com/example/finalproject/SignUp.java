package com.example.finalproject;

import android.content.Intent;
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

                UserModel userModel;

                try {
                    userModel = new UserModel(-1, nameValue.getText().toString(), emailValue.getText().toString(),
                            passwordValue.getText().toString());
                    Toast.makeText(SignUp.this, userModel.toString(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e) {
                    Toast.makeText(SignUp.this, "Error", Toast.LENGTH_SHORT).show();
                    userModel = new UserModel(-1, "error", "none", "none"); //default values if error
                }

                openOptionsPage();

                DbHelper dbHelper = new DbHelper(SignUp.this );

                boolean success = dbHelper.addOne(userModel);
                Toast.makeText(SignUp.this, "Success!"+ success, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void openOptionsPage() {
        Intent intent = new Intent(this, OptionsPage.class);
        startActivity(intent);
    }
}
