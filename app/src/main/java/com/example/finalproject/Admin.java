package com.example.finalproject;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Admin extends AppCompatActivity {

    private DbHelper dbHelper;
    private ListView userListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        // Initialize dbHelper
        dbHelper = new DbHelper(getApplicationContext());

        // Find the ListView from the layout
        userListView = findViewById(R.id.user_list);

        // Retrieve list of users from the database
        ArrayList<String> userList = dbHelper.getAllUsers();

        // Create an ArrayAdapter to display the users in the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, userList);

        // Set the adapter to the ListView
        userListView.setAdapter(adapter);
    }
}
