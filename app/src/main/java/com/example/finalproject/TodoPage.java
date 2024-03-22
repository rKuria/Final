package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TodoPage extends AppCompatActivity {

    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;

     private ListView listView;

     private Button list_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_page);

        listView = findViewById(R.id.listview);
        list_button = findViewById(R.id.list_button);

        list_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem(view);

            }
        });

        items = new ArrayList<>();
        itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(itemsAdapter);
        setUpListViewListener();
    }

    private void setUpListViewListener() {
        //listView.setOnItemLongClickListener();
    }

    private void addItem(View view) {
        EditText input = findViewById(R.id.add_item);
        String itemText = input.getText().toString();

        if(!(itemText.equals(" "))){
            itemsAdapter.add(itemText);
            input.setText(" ");
        }
        else{
            Toast.makeText(TodoPage.this, "No empty text", Toast.LENGTH_SHORT).show();
        }
    }
}