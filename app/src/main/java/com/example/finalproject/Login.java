package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {


    UserModel userModel;

    DbHelper dbHelper = new DbHelper(Login.this);
    public Button button2;

    public EditText login_uname, login_password, login_reenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //assign values to the components
        button2 = findViewById(R.id.button2);
        login_uname = findViewById(R.id.login_uname);
        login_password = findViewById(R.id.login_password);
        login_reenter = findViewById(R.id.login_reenter);

        //button onClick listeners

        //button2.setOnClickListener(new View.OnClickListener() {
           // @Override
            //public void onClick(View view) {
                String username = login_uname.getText().toString();
                String password = login_password.getText().toString();

                boolean result = DbHelper.login(username, password);

                if (result){
                    //userModel.username = login_uname;
                    //userModel.password = login_password;

                    Toast.makeText(Login.this, "User exists", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Login.this, "User not found", Toast.LENGTH_SHORT).show();
                }

            //})
        //})
    }
}